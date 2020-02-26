package com.setebit.inventario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inv_produto")
public class Produto extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Integer id;

	private String codigoBarras;

	private String nome;

	private String endereco;

	private Float quantidadeSistema;

	private Float quantidadeFisica;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Float getQuantidadeSistema() {
		return quantidadeSistema;
	}

	public void setQuantidadeSistema(Float quantidadeSistema) {
		this.quantidadeSistema = quantidadeSistema;
	}

	public Float getQuantidadeFisica() {
		return quantidadeFisica;
	}

	public void setQuantidadeFisica(Float quantidadeFisica) {
		this.quantidadeFisica = quantidadeFisica;
	}

	public Produto(Integer id, String codigoBarras, String nome, String endereco, Float quantidadeSistema,
			Float quantidadeFisica) {
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.endereco = endereco;
		this.quantidadeSistema = quantidadeSistema;
		this.quantidadeFisica = quantidadeFisica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}