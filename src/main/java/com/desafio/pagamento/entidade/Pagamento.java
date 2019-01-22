package com.desafio.pagamento.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPagamento;
	private Double valor;
	@Enumerated(EnumType.STRING)
	private FormaPagamento forma;
	private Cartao cartao;

	public Pagamento(Double valor, FormaPagamento forma, Cartao cartao) {
		super();
		this.valor = valor;
		this.forma = forma;
		this.cartao = cartao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public FormaPagamento getForma() {
		return forma;
	}

	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Long getIdPagamento() {
		return idPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPagamento + ", valor=" + valor + ", tipo=" + forma + ", cartao=" + cartao
				+ "]";
	}

}
