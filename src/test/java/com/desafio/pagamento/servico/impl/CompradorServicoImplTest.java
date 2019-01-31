package com.desafio.pagamento.servico.impl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.pagamento.entidade.Comprador;
import com.desafio.pagamento.repositorio.CompradorRepositorio;
import com.desafio.pagamento.servico.CompradorServico;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompradorServicoImplTest {

	@Autowired
	private CompradorServico compradorServico;

	@Autowired
	private CompradorRepositorio compradorRepositorio;

	Comprador comprador = new Comprador("Bruna", "brunadsilva@gmail.com", "24110174058");
	Comprador compradorSalvo;

	@Before
	public void init() {
		compradorSalvo = compradorServico.salvarComprador(comprador);
	}

	@Test
	public void validarSalvarCompradorComSucesso() {
		Assert.assertNotNull(compradorSalvo);
		Assert.assertNotNull(compradorSalvo.getIdComprador());
		Optional<Comprador> findById = compradorRepositorio.findById(compradorSalvo.getIdComprador());
		Assert.assertNotNull(findById);
	}

	@Test
	public void validarBuscarCompradorCPFComSucesso() {
		Comprador findByCpf = compradorRepositorio.findByCpf(comprador.getCpf());
		Assert.assertEquals(comprador.getCpf(), findByCpf.getCpf());
		Assert.assertNotNull(findByCpf);
	}

	@Test
	public void validarBuscarCompradorComSucesso() {
		Comprador buscarComprador = compradorServico.buscarComprador(comprador);
		Assert.assertEquals(compradorSalvo.getIdComprador(), buscarComprador.getIdComprador());
		Assert.assertNotNull(buscarComprador);
	}
}
