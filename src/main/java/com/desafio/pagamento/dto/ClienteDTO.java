package com.desafio.pagamento.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

public class ClienteDTO {

	@NotEmpty
	private String razaoSocial;
	@CNPJ
	private String cnpj;

	public ClienteDTO(String razaoSocial, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "ClienteDTO [razaoSocial=" + razaoSocial + ", CNPJ=" + cnpj + "]";
	}

}
