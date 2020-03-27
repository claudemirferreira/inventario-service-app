package com.setebit.inventario.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Change collection type field "productTypes" to "ProductTypeDto" instead
 * "ProductType"
 */
public class InventarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date data;

	private String nome;

	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
