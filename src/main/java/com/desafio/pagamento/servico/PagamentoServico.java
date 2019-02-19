package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.desafio.pagamento.dto.RespostaPagamentoDTO;
import com.desafio.pagamento.entidade.Pagamento;

public interface PagamentoServico {

	public RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO);

	public Pagamento buscarPagamento(Long idPagamento);
	
	public String esconderCPF(String cpf);
	
	public boolean removerPagamento(Long idPagamento);
}
