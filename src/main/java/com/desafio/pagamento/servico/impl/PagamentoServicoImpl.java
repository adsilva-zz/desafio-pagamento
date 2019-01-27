package com.desafio.pagamento.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.desafio.pagamento.dto.PagamentoDTO;
import com.desafio.pagamento.entidade.Pagamento;
import com.desafio.pagamento.repositorio.PagamentoRepositorio;
import com.desafio.pagamento.servico.PagamentoServico;

@Service
public class PagamentoServicoImpl implements PagamentoServico {

	@Autowired
	private PagamentoRepositorio pagamentoRepositorio;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Pagamento realizarPagamento(PagamentoDTO pagamentoDTO) {
		Pagamento pag = conversionService.convert(pagamentoDTO, Pagamento.class);

		// validar cartao, identificar bandeira. Futuramente nãoduplicar comprador e
		// cartao
		return pagamentoRepositorio.save(pag);
	}

}
