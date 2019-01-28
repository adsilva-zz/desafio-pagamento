package com.desafio.pagamento.servico;

import com.desafio.pagamento.entidade.Boleto;

public interface BoletoServico {

	public Boleto salvarBoleto(Boleto boleto);

	public Boleto gerarBoleto();
}
