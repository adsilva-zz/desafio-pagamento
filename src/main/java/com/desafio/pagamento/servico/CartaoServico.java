package com.desafio.pagamento.servico;

import com.desafio.pagamento.entidade.CartaoCredito;

public interface CartaoServico {

	public boolean validarCartao(CartaoCredito cartaoCredito);
}
