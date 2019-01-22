package com.desafio.pagamento.dto;

import javax.validation.constraints.NotEmpty;

public class ClienteDTO {

	@NotEmpty
	private String razaoSocial;
	@org.hibernate.validator.constraints.br.CNPJ
	private String CNPJ;

	public ClienteDTO(String razaoSocial, String CNPJ) {
		super();
		this.razaoSocial = razaoSocial;
		this.CNPJ = CNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	@Override
	public String toString() {
		return "ClienteDTO [razaoSocial=" + razaoSocial + ", CNPJ=" + CNPJ + "]";
	}

}
