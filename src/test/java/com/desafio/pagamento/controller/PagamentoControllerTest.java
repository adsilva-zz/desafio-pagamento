package com.desafio.pagamento.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafio.pagamento.dto.RequisicaoPagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(PagamentoController.class)
public class PagamentoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	protected String toJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void validarRealizarPagamento() throws Exception {
		RequisicaoPagamentoDTO body = new RequisicaoPagamentoDTO();
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/pagamentos").accept(MediaType.APPLICATION_JSON)
				.content(toJson(body))).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.valor", Matchers.is(200)));
	}

}
