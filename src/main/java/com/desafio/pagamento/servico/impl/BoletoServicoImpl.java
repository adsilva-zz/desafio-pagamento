package com.desafio.pagamento.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pagamento.entidade.Boleto;
import com.desafio.pagamento.repositorio.BoletoRepositorio;
import com.desafio.pagamento.servico.BoletoServico;

@Service
public class BoletoServicoImpl implements BoletoServico {

	@Autowired
	private BoletoRepositorio boletoRepositorio;

	@Override
	public Boleto salvarBoleto() {
		return boletoRepositorio.save(null);
	}

	@Override
	public Integer gerarNumeroBoleto() {
		return null;
	}

}
