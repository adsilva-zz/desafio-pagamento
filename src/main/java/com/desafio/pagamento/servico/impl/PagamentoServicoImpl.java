package com.desafio.pagamento.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.desafio.pagamento.entidade.CartaoCredito;
import com.desafio.pagamento.entidade.Cliente;
import com.desafio.pagamento.entidade.Comprador;
import com.desafio.pagamento.entidade.FormaPagamento;
import com.desafio.pagamento.entidade.Pagamento;
import com.desafio.pagamento.entidade.Status;
import com.desafio.pagamento.repositorio.PagamentoRepositorio;
import com.desafio.pagamento.servico.CartaoServico;
import com.desafio.pagamento.servico.CompradorServico;
import com.desafio.pagamento.servico.PagamentoServico;

@Service
public class PagamentoServicoImpl implements PagamentoServico {

	@Autowired
	private PagamentoRepositorio pagamentoRepositorio;

	@Autowired
	private CartaoServico cartaoServico;

	@Autowired
	private CompradorServico compradorServico;

	@Autowired
	private ConversionService conversionService;
	
	//private static Integer NUM_BOLETO = 0;

	@Override
	public Pagamento realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO) {

		Pagamento pag = conversionService.convert(requisicaoPagamentoDTO.getPagamento(), Pagamento.class);

		// Converte cliente e atribui no pagamento
		Cliente cliente = conversionService.convert(requisicaoPagamentoDTO.getCliente(), Cliente.class);
		pag.setCliente(cliente);

		// Verifica se existe o comprador
		Comprador comprador = compradorServico.buscarCompradorCPF(requisicaoPagamentoDTO.getComprador().getCpf());
		if (!ObjectUtils.isEmpty(comprador)) {
			pag.setComprador(comprador);
		} else {// salva o comprador, caso não existe
			Comprador compradorNovo = conversionService.convert(requisicaoPagamentoDTO.getComprador(), Comprador.class);
			pag.setComprador(compradorServico.salvarComprador(compradorNovo));
		}

		// Verifica se a forma de pagamento é cartão de crédito
		if (FormaPagamento.CARTAO_CREDITO.equals(pag.getForma())) {
			CartaoCredito cc = (CartaoCredito) pag.getCartao();
			// Validar o cartão de crédito
			cartaoServico.validarCartao(cc);
			cc.setTipoBandeira(cartaoServico.identificarBandeira(cc.getNumero()));
			pag.setCartao(cartaoServico.salvarCartao(cc));
		} else {
			//boleto -> gero proximo numero boleto
		}
		pag.setStatus(Status.ENVIADO);
		return pagamentoRepositorio.save(pag);
	}

}
