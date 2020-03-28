package com.setebit.inventario.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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

}