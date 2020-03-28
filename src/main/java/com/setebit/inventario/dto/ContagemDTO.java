package com.setebit.inventario.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.setebit.inventario.model.Produto;

public class ContagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer numeroContagem;

	private Float quantidade;

	private List<LancamentoDTO> lancamentos = new ArrayList<LancamentoDTO>();

	private Produto produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroContagem() {
		return numeroContagem;
	}

	public void setNumeroContagem(Integer numeroContagem) {
		this.numeroContagem = numeroContagem;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public List<LancamentoDTO> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<LancamentoDTO> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}