package com.desafio.pagamento.exception;

public class Message<T> {

	private String mensagem;
	private T corpo;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public T getCorpo() {
		return corpo;
	}

	public void setCorpo(T corpo) {
		this.corpo = corpo;
	}

	public Message(String mensagem, T corpo) {
		super();
		this.mensagem = mensagem;
		this.corpo = corpo;
	}

	public Message() {
		super();
	}

}
