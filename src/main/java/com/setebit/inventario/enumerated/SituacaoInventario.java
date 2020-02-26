package com.setebit.inventario.enumerated;

public enum SituacaoInventario {

	CADASTRADO("C"), ABERTO("A"), FECHADO("F");

	private String situacao;

	SituacaoInventario(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return this.situacao;
	}

}