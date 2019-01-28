package com.desafio.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.pagamento.entidade.CartaoCredito;

@ControllerAdvice
public class ControllerAdviceCustom {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<Message<Long>> autorNaoEncontradoException(ClienteNaoEncontradoException ex) {
		Message<Long> mensagem = new Message<>("Cliente não encontrado", ex.getIdCliente());
		return new ResponseEntity<Message<Long>>(mensagem, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CartaoInvalidoException.class)
	public ResponseEntity<Message<CartaoCredito>> cartaoInvalidoException(CartaoInvalidoException ex) {
		Message<CartaoCredito> mensagem = new Message<>("Cartão de crédito inválido", null);
		return new ResponseEntity<Message<CartaoCredito>>(mensagem, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CartaoNuloException.class)
	public ResponseEntity<Message<Void>> cartaoNuloException() {
		Message<Void> mensagem = new Message<>("Informe os dados do cartão", null);
		return new ResponseEntity<Message<Void>>(mensagem, HttpStatus.BAD_REQUEST);
	}
}
