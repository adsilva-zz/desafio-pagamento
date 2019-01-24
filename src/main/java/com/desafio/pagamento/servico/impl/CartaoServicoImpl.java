package com.desafio.pagamento.servico.impl;

import org.springframework.stereotype.Service;

import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.servico.CartaoServico;

@Service
public class CartaoServicoImpl implements CartaoServico {

	@Override
	public boolean validarCartao(CartaoCredito cartaoCredito) {
		// TODO Auto-generated method stub
		return false;
	}

}
