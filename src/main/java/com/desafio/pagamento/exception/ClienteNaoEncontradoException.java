package com.desafio.pagamento.exception;

public class ClienteNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idCliente;

	public ClienteNaoEncontradoException(Long idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
