package com.desafio.pagamento.exception;

import com.desafio.pagamento.entidade.CartaoCredito;

public class CartaoInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CartaoCredito cartaoCredito;

	public CartaoInvalidoException(CartaoCredito cartaoCredito) {
		super();
		this.cartaoCredito = cartaoCredito;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

}
