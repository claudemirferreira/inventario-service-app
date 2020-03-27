package com.setebit.inventario.dto;

import java.io.Serializable;

/**
 * Change collection type field "productTypes" to "ProductTypeDto" instead
 * "ProductType"
 */
public class CompanyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
