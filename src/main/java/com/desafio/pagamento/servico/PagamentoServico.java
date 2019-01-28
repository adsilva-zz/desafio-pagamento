package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.desafio.pagamento.dto.RespostaPagamentoDTO;

public interface PagamentoServico {

	public RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO);

}
