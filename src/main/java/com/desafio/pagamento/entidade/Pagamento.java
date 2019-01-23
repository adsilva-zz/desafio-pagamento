package com.desafio.pagamento.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@OneToOne
	@JoinColumn(name = "idCartao")
	private Cartao cartao;
	@OneToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "idComprador")
	private Comprador comprador;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Pagamento(Double valor, FormaPagamento forma, Cartao cartao, Cliente cliente, Comprador comprador,
			Status status) {
		super();
		this.valor = valor;
		this.forma = forma;
		this.cartao = cartao;
		this.cliente = cliente;
		this.comprador = comprador;
		this.status = status;
	}

	public Pagamento() {

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
