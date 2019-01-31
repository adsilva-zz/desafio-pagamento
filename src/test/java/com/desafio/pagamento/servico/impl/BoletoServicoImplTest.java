package com.desafio.pagamento.servico.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.pagamento.entidade.Boleto;
import com.desafio.pagamento.servico.BoletoServico;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BoletoServicoImplTest {

	@Autowired
	private BoletoServico boletoServico;

	Boleto boleto = new Boleto();

	@Test
	public void validarGerarBoletoComSucesso() {
		Boleto gerarBoleto = boletoServico.gerarBoleto();
		Assert.assertNotNull(gerarBoleto);
	}

	@Test
	public void validarSalvarBoletoComSucesso() {
		Boleto boleto = boletoServico.gerarBoleto();
		Assert.assertEquals(boleto, boletoServico.salvarBoleto(boleto));
	}
}
