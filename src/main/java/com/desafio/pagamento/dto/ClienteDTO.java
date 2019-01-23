package com.desafio.pagamento.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO {

	@NotNull
	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public ClienteDTO(Long idCliente) {
		super();
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + "]";
	}

}
