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

	@Test
	public void validarGerarBoletoComSucesso() {
		Boleto gerarBoleto = boletoServico.gerarBoleto();
		Assert.assertNotNull(gerarBoleto);
		Assert.assertNotNull(gerarBoleto.getNumeroBoleto());
	}

	@Test
	public void validarSalvarBoletoComSucesso() {
		Boleto boleto = boletoServico.gerarBoleto();
		Boleto boletoSalvo = boletoServico.salvarBoleto(boleto);

		Assert.assertEquals(boleto.getDataVencimento(), boletoSalvo.getDataVencimento());
		Assert.assertEquals(boleto.getNumeroBoleto(), boletoSalvo.getNumeroBoleto());
	}
}
