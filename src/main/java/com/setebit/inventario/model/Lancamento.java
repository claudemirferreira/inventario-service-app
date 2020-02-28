package com.setebit.inventario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inv_lancamento")
public class Lancamento extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lanc_id")
	private Integer id;

	private Float quantidade;

	@Column(length = 100)
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "cont_id", referencedColumnName = "cont_id", nullable = false)
	private Contagem contagem;

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

	public Contagem getContagem() {
		return contagem;
	}

	public void setContagem(Contagem contagem) {
		this.contagem = contagem;
	}

	public Lancamento() {
	}

	public Lancamento(Integer id, Float quantidade, String observacao, Contagem contagem) {
		this.id = id;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.contagem = contagem;
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
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}