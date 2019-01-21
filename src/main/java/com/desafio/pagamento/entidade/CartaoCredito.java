package com.desafio.pagamento.entidade;

import java.time.LocalDate;

public class CartaoCredito extends Cartao {

	private String CVV;

	public CartaoCredito(String name, String numero, LocalDate dataValidade, String CVV) {
		super(name, numero, dataValidade);
		this.CVV = CVV;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	@Override
	public String toString() {
		return "CartaoCredito [CVV=" + CVV + "]";
	}

}
