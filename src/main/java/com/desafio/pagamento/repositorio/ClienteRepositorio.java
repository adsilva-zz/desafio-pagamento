package com.desafio.pagamento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.pagamento.entidade.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	// metodos adicionais
}
