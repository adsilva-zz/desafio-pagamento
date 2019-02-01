package com.desafio.pagamento.servico.impl;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.entidade.TipoBandeira;
import com.desafio.pagamento.exception.CartaoInvalidoException;
import com.desafio.pagamento.servico.CartaoServico;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CartaoServicoImplTest {

	@Autowired
	private CartaoServico cartaoServico;

	CartaoCredito cartaoMastesCard = new CartaoCredito("Carla Santos", "5446972973560379", LocalDate.now().plusYears(3),
			"737");

	CartaoCredito cartaoVisa = new CartaoCredito("Carla Santos", "4485265266556559", LocalDate.of(2019, 10, 31), "182");

	CartaoCredito cartaoAmericanExpress = new CartaoCredito("Carla Santos", "378856551391153",
			LocalDate.of(2019, 05, 31), "236");

	CartaoCredito cartaoAExpress2 = new CartaoCredito("Carla Santos", "341119817440437", LocalDate.of(2019, 05, 31),
			"236");

	CartaoCredito cartaoElo = new CartaoCredito("Carla Santos", "4011045499285470", LocalDate.of(2020, 01, 31), "573");

	CartaoCredito cartaoHipercard = new CartaoCredito("Carla Santos", "6062825854058643", LocalDate.of(2030, 01, 31),
			"784");

	CartaoCredito cartaoSemBandeira = new CartaoCredito("Carla Santos", "201419312362501", LocalDate.of(2020, 01, 21),
			"347");

	@Test
	public void validarNumeroCartaoComSucesso() {
		Assert.assertTrue(cartaoServico.validarNumeroCartao(cartaoMastesCard.getNumero()));
		Assert.assertTrue(cartaoServico.validarNumeroCartao(cartaoSemBandeira.getNumero()));
	}

	@Test
	public void validarCVVComSucesso() {
		Assert.assertTrue(cartaoServico.validarCvvCartao(cartaoMastesCard.getCvv()));
	}

	@Test
	public void validarCVVComFalha() {
		Assert.assertFalse(cartaoServico.validarCvvCartao("1234"));
		Assert.assertFalse(cartaoServico.validarCvvCartao("-234"));
		Assert.assertFalse(cartaoServico.validarCvvCartao("   "));
		Assert.assertFalse(cartaoServico.validarCvvCartao("abc"));
	}

	@Test
	public void validarDataValidadeComSucesso() {
		Assert.assertTrue(cartaoServico.validarDataValidade(cartaoMastesCard.getDataValidade()));
		Assert.assertTrue(cartaoServico.validarDataValidade(LocalDate.now()));
	}

	@Test
	public void validarDataValidadeComFalha() {
		Assert.assertFalse(cartaoServico.validarDataValidade(LocalDate.of(2010, 01, 21)));
		Assert.assertFalse(cartaoServico.validarDataValidade(null));
	}

	@Test
	public void validarIdentificarBandeiraComSucesso() {
		Assert.assertEquals(TipoBandeira.MASTERCARD, cartaoServico.identificarBandeira(cartaoMastesCard.getNumero()));

		Assert.assertEquals(TipoBandeira.VISA, cartaoServico.identificarBandeira(cartaoVisa.getNumero()));

		Assert.assertEquals(TipoBandeira.AMERICAN_EXPRESS,
				cartaoServico.identificarBandeira(cartaoAmericanExpress.getNumero()));

		Assert.assertEquals(TipoBandeira.AMERICAN_EXPRESS,
				cartaoServico.identificarBandeira(cartaoAExpress2.getNumero()));

		Assert.assertEquals(TipoBandeira.ELO, cartaoServico.identificarBandeira(cartaoElo.getNumero()));

		Assert.assertEquals(TipoBandeira.HIPERCARD, cartaoServico.identificarBandeira(cartaoHipercard.getNumero()));

		Assert.assertEquals(TipoBandeira.DESCONHECIDO,
				cartaoServico.identificarBandeira(cartaoSemBandeira.getNumero()));
	}

	@Test
	public void validarCartaoComSucesso() {
		Assert.assertTrue(cartaoServico.validarCartao(cartaoVisa));
		Assert.assertTrue(cartaoServico.validarCartao(cartaoMastesCard));
	}

	@Test
	public void validarCartaoComFalhaNumero() {
		CartaoCredito numeroErrado = new CartaoCredito("Amanda", "1112222222222222", LocalDate.of(2020, 01, 21), "123");
		try {
			cartaoServico.validarCartao(numeroErrado);
			Assert.fail();
		} catch (CartaoInvalidoException e) {
			Assert.assertNotNull(e);
		}
	}

	@Test(expected = CartaoInvalidoException.class)
	public void validarCartaoComFalhaData() {
		CartaoCredito dataErrada = new CartaoCredito("Amanda", "4485265266556559", LocalDate.of(2010, 01, 21), "123");
		cartaoServico.validarCartao(dataErrada);
	}

	@Test
	public void validarCartaoComFalhaCvv() {
		CartaoCredito cvvErrado = new CartaoCredito("Amanda", "4485265266556559", LocalDate.of(2010, 01, 21), "3123");
		try {
			cartaoServico.validarCartao(cvvErrado);
			Assert.fail();
		} catch (CartaoInvalidoException e) {
			Assert.assertNotNull(e);
		}
	}

	@Test
	public void validarSalvarCartaoComSucesso() {
		Assert.assertNotNull(cartaoServico.salvarCartao(cartaoElo));

		CartaoCredito cartaoSalvo = cartaoServico.salvarCartao(cartaoAmericanExpress);
		Assert.assertEquals(cartaoAmericanExpress.getTipoBandeira(), cartaoSalvo.getTipoBandeira());
		Assert.assertEquals(cartaoAmericanExpress.getName(), cartaoSalvo.getName());
		Assert.assertEquals(cartaoAmericanExpress.getNumero(), cartaoSalvo.getNumero());
	}

}
