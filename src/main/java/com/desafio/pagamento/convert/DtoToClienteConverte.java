package com.desafio.pagamento.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.desafio.pagamento.dto.ClienteDTO;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.servico.ClienteServico;

@Component
public class DtoToClienteConverte implements Converter<ClienteDTO, Cliente> {

	@Autowired
	private ClienteServico clienteServico;

	@Override
	public Cliente convert(ClienteDTO clienteDTO) {
		Cliente c = clienteServico.buscarCliente(clienteDTO);
		if (ObjectUtils.isEmpty(c)) {
			// lançar exceção
		}
		Cliente cliente = c;
		return cliente;
	}

}
