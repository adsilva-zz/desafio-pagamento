package com.desafio.pagamento.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartaoDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String numero;
	@NotNull
	private LocalDate dataValidade;
	@NotEmpty
	private String cvv;

	public CartaoDTO(String nome, String numero, LocalDate dataValidade, String cvv) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.dataValidade = dataValidade;
		this.cvv = cvv;
	}

	public CartaoDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "CartaoDTO [nome=" + nome + ", numero=" + numero + ", dataValidade=" + dataValidade + ", cvv=" + cvv
				+ "]";
	}

}
