package com.setebit.inventario.dto;

import java.io.Serializable;

public class LancamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Float quantidade;

	private String observacao;

	private ContagemDTO contagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ContagemDTO getContagem() {
		return contagem;
	}

	public void setContagem(ContagemDTO contagem) {
		this.contagem = contagem;
	}

}