package io.github.vcosmusjoao.clientes.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//banco de dados fica responsavel por auto incrementar o id
    private Integer id;

    @Column(nullable = false,length = 150)//not null,  tamanho do nome do cliente
    private String nome;

    @Column(nullable = false,length = 11)//not null, tamanho do  cpf
    private String cpf;

    @Column(name = "data_cadastro")
    private LocalDate dataDoCadastro;



}
