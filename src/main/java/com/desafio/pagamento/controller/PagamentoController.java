package com.desafio.pagamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.desafio.pagamento.dto.RespostaPagamentoDTO;
import com.desafio.pagamento.entidade.Pagamento;
import com.desafio.pagamento.servico.PagamentoServico;

@RestController
@RequestMapping("api/v1/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoServico pagamentoServico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RespostaPagamentoDTO> realizarPagamento(
			@Valid @RequestBody RequisicaoPagamentoDTO requisicaoPagamentoDTO) {
		return new ResponseEntity<RespostaPagamentoDTO>(pagamentoServico.realizarPagamento(requisicaoPagamentoDTO),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pagamento> buscarPagamento(@PathVariable(value = "id") Long id) {
		Pagamento pagamento = pagamentoServico.buscarPagamento(id);
		if (ObjectUtils.isEmpty(pagamento)) {
			return new ResponseEntity<Pagamento>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removerPagamento(@PathVariable(value = "id") Long idPagamento) {
		if (!pagamentoServico.removerPagamento(idPagamento)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
