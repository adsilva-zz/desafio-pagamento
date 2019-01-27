package com.desafio.pagamento.servico.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.entidade.TipoBandeira;
import com.desafio.pagamento.servico.CartaoServico;

@Service
public class CartaoServicoImpl implements CartaoServico {

	@Override
	public boolean validarCartao(CartaoCredito cartaoCredito) {

		CartaoCredito cartao = cartaoCredito;

		if (!validarNumeroCartao(cartao.getNumero())) {
			// lançar excecao de cartão invalido
		}
		if (!validarDataValidade(cartao.getDataValidade())) {
			// lancar exceção de cartao invalido
		}
		if (!validarCvvCartao(cartao.getCvv())) {
			// lançar exceção de cartao
		}
		return true;
	}

	@Override
	public boolean validarNumeroCartao(String numCartao) {
		Integer numString;
		int soma = 0;
		if (numCartao.length() <= 15) {
			for (int i = 0; i <= numCartao.length(); i++) {
				numString = Integer.parseInt(numCartao.substring(i, i + 1));
				if (i % 2 == 0) {
					soma += numString;
				} else {
					if ((numString * 2) > 9) {
						soma += ((numString * 2) - 9);
					} else {
						soma += (numString * 2);
					}
				}
			}
		}
		if (numCartao.length() >= 16) {
			for (int i = 0; i <= numCartao.length(); i++) {
				numString = Integer.parseInt(numCartao.substring(i, i + 1));
				if (i % 2 == 0) {
					if (numString * 2 > 9) {
						soma += (numString * 2 - 9);
					} else {
						soma += (numString * 2);
					}
				} else {
					soma += numString;
				}
			}
		}
		return soma % 10 == 0;
	}

	@Override
	public boolean validarCvvCartao(String cvv) {
		if (Integer.parseInt(cvv) < 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validarDataValidade(LocalDate dataValidade) {
		if (LocalDate.now().isAfter(dataValidade)) {
			return false;
		}
		return true;
	}

	@Override
	public TipoBandeira identificarBandeira(String numCartao) {
		List<String> listaElo = Arrays.asList("636368", "438935", "504175", "451416", "509048", "509067", "509049",
				"509069", "509050", "509074", "509068", "509040", "509045", "509051", "509046", "509066", "509047",
				"509042", "509052", "509043", "509064", "509040", "36297", "5067", "4576", "4011");

		for (String num : listaElo) {
			if (num.equals(numCartao.substring(0, num.length() + 1))) {
				return TipoBandeira.ELO;
			}
		}

		if ("34".equals(numCartao.substring(0, 2)) || "37".equals(numCartao.substring(0, 2))) {
			return TipoBandeira.AMEX;
		}

		if ("38".equals(numCartao.substring(0, 2)) || "60".equals(numCartao.substring(0, 2))) {
			return TipoBandeira.HIPERCARD;
		}

		if ("4".equals(numCartao.substring(0))) {
			return TipoBandeira.VISA;
		}

		if ("5".equals(numCartao.substring(0))) {
			return TipoBandeira.MASTERCARD;
		}

		return null;
	}
}
