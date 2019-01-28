package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.desafio.pagamento.entidade.Pagamento;

public interface PagamentoServico {

	public Pagamento realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO);

}
