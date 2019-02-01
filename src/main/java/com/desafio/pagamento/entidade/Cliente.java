package com.desafio.pagamento.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	@Column(length = 100)
	private String razaoSocial;
	private String cnpj;

	public Cliente(String razaoSocial, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Cliente() {

	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", razaoSocial=" + razaoSocial + ", CNPJ=" + cnpj + "]";
	}

}
