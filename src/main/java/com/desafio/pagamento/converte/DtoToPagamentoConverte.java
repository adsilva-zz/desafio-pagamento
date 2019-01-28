package com.desafio.pagamento.converte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.desafio.pagamento.dto.PagamentoDTO;
import com.desafio.pagamento.entidade.FormaPagamento;
import com.desafio.pagamento.entidade.Pagamento;
import com.desafio.pagamento.exception.CartaoNuloException;

@Component
public class DtoToPagamentoConverte implements Converter<PagamentoDTO, Pagamento> {

	@Autowired
	private DtoToCartaoConverte cartaoConverte;

	@Override
	public Pagamento convert(PagamentoDTO pagamentoDTO) {
		Pagamento pagamento = new Pagamento();
		if (FormaPagamento.CARTAO_CREDITO.equals(pagamentoDTO.getForma())) {
			if (ObjectUtils.isEmpty(pagamentoDTO.getCartao())) {
				throw new CartaoNuloException();
			}
			pagamento.setCartao(cartaoConverte.convert(pagamentoDTO.getCartao()));
		}

		pagamento.setForma(pagamentoDTO.getForma());
		pagamento.setValor(pagamentoDTO.getValor());
		return pagamento;
	}

}
