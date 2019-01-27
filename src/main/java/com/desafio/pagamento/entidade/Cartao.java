package com.desafio.pagamento.entidade;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCartao;
	private String name;
	private String numero;
	private LocalDate dataValidade;
	@Enumerated(EnumType.STRING)
	private TipoBandeira tipoBandeira;

	public Cartao(String name, String numero, LocalDate dataValidade) {
		super();
		this.name = name;
		this.numero = numero;
		this.dataValidade = dataValidade;
	}

	public Cartao() {

	}

	public Long getIdCartao() {
		return idCartao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public TipoBandeira getTipoBandeira() {
		return tipoBandeira;
	}

	public void setTipoBandeira(TipoBandeira tipoBandeira) {
		this.tipoBandeira = tipoBandeira;
	}

	@Override
	public String toString() {
		return "Cartao [name=" + name + ", numero=" + numero + ", dataValidade=" + dataValidade + "]";
	}
}
