package com.desafio.pagamento.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comprador")
public class Comprador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComprador;
	@Column(length = 50)
	private String nome;
	private String email;
	private String cpf;

	public Comprador(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public Comprador() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	@Override
	public String toString() {
		return "Comprador [idComprador=" + idComprador + ", nome=" + nome + ", email=" + email + ", CPF=" + cpf + "]";
	}

}
