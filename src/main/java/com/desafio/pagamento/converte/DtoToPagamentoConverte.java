package com.desafio.pagamento.converte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.desafio.pagamento.dto.PagamentoDTO;
import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.entidade.Comprador;
import com.desafio.pagamento.entidade.FormaPagamento;
import com.desafio.pagamento.entidade.Pagamento;

@Component
public class DtoToPagamentoConverte implements Converter<PagamentoDTO, Pagamento> {

	@Autowired
	private DtoToClienteConverte clienteConverte;

	@Autowired
	private DtoToCartaoConverte cartaoConverte;

	@Autowired
	private DtoToCompradorConverte compradorConverte;

	@Override
	public Pagamento convert(PagamentoDTO pagamentoDTO) {

		Pagamento pagamento = new Pagamento();
		pagamento.setCliente(clienteConverte.convert(pagamentoDTO.getCliente()));
		pagamento.setComprador(compradorConverte.convert(pagamentoDTO.getComprador()));

		if (FormaPagamento.CARTAO_CREDITO.equals(pagamentoDTO.getForma())) {
			pagamento.setCartao(cartaoConverte.convert(pagamentoDTO.getCartao()));
		}

		pagamento.setForma(pagamentoDTO.getForma());
		pagamento.setValor(pagamentoDTO.getValor());
		return pagamento;
	}

}
