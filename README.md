# Desafio pagamento-API

API de pagamento que realiza processamento de solicitaçoes de compra por boleto e cartão de crédito. 
Para o processamento é necessário enviar os dados do cliente, comprador, forma de pagamento e o cartão de crédito quando a forma de pagamento é cartão de crédito.
A API verifica se o cartão de crédito é válido, verifica se o cliente e o comprador já existe no sistema, caso já existam ela vincula os mesmos com o pagamento a ser processado. Quando a forma de pagamento é boleto a API gera um boleto e retorna o boleto gerado.
A API permite consultar os dados do pagamento enviado para processamento.

## Tecnologias Utilizadas
O projeto foi criado com Spring Boot na linguagem de programação Java com BD MySQL, Spring Data JPA e realizado testes unitários com JUnit.

## Arquitetura 
O projeto está divido nas seguintes camadas:

*main:*
1. Entidade  
2. Repositório
3. Serviço
4. Controle
5. DTO
6. Converte
7. Exceção

*test:*
1. Serviço

## Como executar
1. Clonar o projeto
2. Ter instalado o BD MySQL 
3. Configurar no aplication.properties a conexão do BD
4. Executar no terminal o comando: ``mvn spring-boot:run``
5. Realizar o cadastro de um Cliente no BD

## Como testar 
O sistema possui dois endpoint: 
1. **``POST api/v1/pagamentos``**: Requisita o processamento do pagamento que está enviando no corpo da solicitação.
*Exemplo do corpo da requisição para Cartão de Crédito:*
```javascript
{
	"pagamento" :{
		"valor": 233.52,
		"forma" : "CARTAO_CREDITO",
		"cartao":{
			"name":"Ana Carla",
			"numero": "379933881288935",
			"dataValidade": "2020-06-27",
			"cvv": "377"
		}
	},
	"cliente":{
		"idCliente":1
	},
	"comprador":{
		"nome":"Amanda",
		"email": "amanda.adsilva@gmail.com",
		"cpf": "95099846041"
	}
}
```

*Exemplo do corpo da requisição para Boleto:*
```javascript
{
	"pagamento" :{
		"valor": 233.52,
		"forma" : "BOLETO"
	},
	"cliente":{
		"idCliente":1
	},
	"comprador":{
		"nome":"Amanda",
		"email": "amanda.adsilva@gmail.com",
		"cpf": "95099846041"
	}
}
```

2. **``GET api/v1/pagamentos/{id}``**: Requisita os dados do pagamento do id informado na URL

