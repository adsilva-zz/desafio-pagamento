package com.desafio.pagamento.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO {

	@NotNull
	private Long idCliente;

	public ClienteDTO() {

	}

	public ClienteDTO(Long idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + "]";
	}

	
}
