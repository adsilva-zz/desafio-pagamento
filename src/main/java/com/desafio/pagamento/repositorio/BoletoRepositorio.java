package com.desafio.pagamento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.pagamento.entidade.Boleto;

@Repository
public interface BoletoRepositorio extends JpaRepository<Boleto, Long> {

}
