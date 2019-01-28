package com.desafio.pagamento.dto;

import com.desafio.pagamento.entidade.FormaPagamento;
import com.desafio.pagamento.entidade.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RespostaPagamentoDTO {

	private Long idPagamento;
	private double valor;
	private FormaPagamento forma;
	private Status status;
	@JsonInclude(Include.NON_NULL)
	private Integer numeroBoleto;

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public FormaPagamento getForma() {
		return forma;
	}

	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getNumeroBoleto() {
		return numeroBoleto;
	}

	public void setNumeroBoleto(Integer numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}

	@Override
	public String toString() {
		return "RespostaPagamentoDTO [idPagamento=" + idPagamento + ", valor=" + valor + ", forma=" + forma
				+ ", status=" + status + ", numeroBoleto=" + numeroBoleto + ", getIdPagamento()=" + getIdPagamento()
				+ ", getValor()=" + getValor() + ", getForma()=" + getForma() + ", getStatus()=" + getStatus()
				+ ", getNumeroBoleto()=" + getNumeroBoleto() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
