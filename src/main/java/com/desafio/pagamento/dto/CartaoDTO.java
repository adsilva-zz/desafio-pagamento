package com.desafio.pagamento.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CartaoDTO {

	@NotEmpty
	private String name;
	@NotEmpty
	private String numero;
	@NotNull
	private LocalDate dataValidade;
	@NotEmpty
	private String cvv;

	public CartaoDTO(String name, String numero, LocalDate dataValidade, String cvv) {
		super();
		this.name = name;
		this.numero = numero;
		this.dataValidade = dataValidade;
		this.cvv = cvv;
	}

	public CartaoDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CartaoDTO [name=" + name + ", numero=" + numero + ", dataValidade=" + dataValidade + ", cvv=" + cvv
				+ "]";
	}

}
