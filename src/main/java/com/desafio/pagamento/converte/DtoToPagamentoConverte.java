package com.desafio.pagamento.converte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.desafio.pagamento.dto.PagamentoDTO;
import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.entidade.Comprador;
import com.desafio.pagamento.entidade.Pagamento;

@Component
public class DtoToPagamentoConverte implements Converter<PagamentoDTO, Pagamento> {

	@Autowired
	private ConversionService conversionService;

	@Override
	public Pagamento convert(PagamentoDTO pagamentoDTO) {

		Pagamento pagamento = new Pagamento();
		pagamento.setCliente(conversionService.convert(pagamentoDTO.getCliente(), Cliente.class));
		pagamento.setComprador(conversionService.convert(pagamentoDTO.getComprador(), Comprador.class));
		pagamento.setCartao(conversionService.convert(pagamentoDTO.getCartao(), CartaoCredito.class));
		pagamento.setForma(pagamentoDTO.getForma());
		pagamento.setValor(pagamentoDTO.getValor());
		return pagamento;
	}

}
