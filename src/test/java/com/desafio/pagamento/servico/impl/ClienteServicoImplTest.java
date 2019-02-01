package com.desafio.pagamento.servico.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.pagamento.dto.ClienteDTO;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.repositorio.ClienteRepositorio;
import com.desafio.pagamento.servico.ClienteServico;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServicoImplTest {

	@Autowired
	private ClienteServico clienteServico;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Test
	public void validarBuscarClienteComSucesso() {
		Cliente cliente = clienteRepositorio.save(new Cliente("Empresa dos Sonhos", "1232144663447687"));
		Assert.assertNotNull(cliente);
		
		Cliente buscarCliente = clienteServico.buscarCliente(new ClienteDTO(cliente.getIdCliente()));
		Assert.assertNotNull(buscarCliente);
		Assert.assertEquals(cliente.getIdCliente(), buscarCliente.getIdCliente());

	}
}
