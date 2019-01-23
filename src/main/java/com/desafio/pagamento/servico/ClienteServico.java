package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.ClienteDTO;
import com.desafio.pagamento.entidade.Cliente;

public interface ClienteServico {

	public Cliente buscarCliente(ClienteDTO clienteDTO);
	
	
}
