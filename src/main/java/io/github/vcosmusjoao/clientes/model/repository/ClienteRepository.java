package io.github.vcosmusjoao.clientes.model.repository;

import io.github.vcosmusjoao.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
