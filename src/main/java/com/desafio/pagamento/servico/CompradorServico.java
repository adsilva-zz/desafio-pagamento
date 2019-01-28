package com.desafio.pagamento.servico;

import com.desafio.pagamento.entidade.Comprador;

public interface CompradorServico {

	public Comprador buscarComprador(Comprador comprador);

	public Comprador buscarCompradorCPF(String cpf);
	
	public Comprador salvarComprador(Comprador comprador);
}
