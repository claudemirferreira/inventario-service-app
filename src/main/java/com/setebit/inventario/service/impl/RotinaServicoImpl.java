package com.setebit.inventario.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.repository.RotinaRepositorio;
import com.setebit.inventario.repository.RotinaRepositorioSql;
import com.setebit.inventario.service.RotinaServico;

@Service
public class RotinaServicoImpl implements RotinaServico, Serializable {

	private static final long serialVersionUID = -4128328556228022891L;

	@Autowired
	private RotinaRepositorio rotinaRepositorio;

	@Autowired
	private RotinaRepositorioSql rotinaRepositorioSql;

	@Override
	public List<Rotina> listarTodos() {
		return this.rotinaRepositorio.findAll();
	}

	@Override
	public Rotina salvar(Rotina rotina) {
		return this.rotinaRepositorio.save(rotina);
	}

	@Override
	public void remover(Rotina rotina) {
		this.rotinaRepositorio.delete(rotina);

	}

	@Override
	public List<Rotina> listaRotinasPorPerfil(int id) {
		return rotinaRepositorioSql.listaRotinasPorPerfil(id);
	}

	@Override
	public List<Rotina> findByNomeLike(String nome) {
		return this.rotinaRepositorio.findByNomeLike(nome);
	}

	@Override
	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil) {
		return this.rotinaRepositorio.listarRotinaPorPerfil(idPerfil);
	}
}