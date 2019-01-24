package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.PagamentoDTO;
import com.desafio.pagamento.entidade.Pagamento;

public interface PagamentoServico {

	public Pagamento realizarPagamento(PagamentoDTO pagamentoDTO);
	
}

