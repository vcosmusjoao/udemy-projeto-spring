package io.github.vcosmusjoao.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//banco de dados fica responsavel por auto incrementar o id
    private Integer id;

    @Column(nullable = false,length = 150)//not null,  tamanho do nome do cliente
    @NotEmpty
    private String nome;

    @Column(nullable = false,length = 11)//not null, tamanho do  cpf
    @NotNull
    @CPF
    private String cpf;

    @Column(name = "data_cadastro",updatable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataDoCadastro;


//metodo pre Persist executa algo antes de persistir, ou seja ele seta automaticamente a data do cadastro
    @PrePersist
    public void prePersist(){
        setDataDoCadastro(LocalDate.now());
    }

}
