package com.desafio.pagamento.dto;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.desafio.pagamento.entidade.Cartao;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.entidade.Comprador;
import com.desafio.pagamento.entidade.FormaPagamento;

public class PagamentoDTO {

	@NotNull
	private Double valor;
	@NotNull
	private FormaPagamento forma;
	@NotNull
	private Cartao cartao;
	@NotNull
	private Cliente cliente;
	@NotNull
	private Comprador comprador;

	public PagamentoDTO(Double valor, FormaPagamento forma, Cartao cartao, Cliente cliente, Comprador comprador) {
		super();
		this.valor = valor;
		this.forma = forma;
		this.cartao = cartao;
		this.cliente = cliente;
		this.comprador = comprador;
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

	@Override
	public String toString() {
		return "PagamentoDTO [valor=" + valor + ", forma=" + forma + ", cartao=" + cartao + ", cliente=" + cliente
				+ ", comprador=" + comprador + "]";
	}

}
