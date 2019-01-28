package com.desafio.pagamento.dto;

import javax.validation.constraints.NotNull;

public class RequisicaoPagamentoDTO {

	@NotNull
	private PagamentoDTO pagamento;
	@NotNull
	private ClienteDTO cliente;
	@NotNull
	private CompradorDTO comprador;

	public PagamentoDTO getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoDTO pagamento) {
		this.pagamento = pagamento;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public CompradorDTO getComprador() {
		return comprador;
	}

	public void setComprador(CompradorDTO comprador) {
		this.comprador = comprador;
	}

}
