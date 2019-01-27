package com.desafio.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceCustom {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<Message<Long>> autorNaoEncontradoException(ClienteNaoEncontradoException ex) {
		Message<Long> mensagem = new Message<>("Cliente não encontrado", ex.getIdCliente());
		return new ResponseEntity<Message<Long>>(mensagem, HttpStatus.BAD_REQUEST);
	}
}
