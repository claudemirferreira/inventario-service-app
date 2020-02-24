package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Rotina;

public interface RotinaServico {

	public List<Rotina> listarTodos();

	public Rotina salvar(Rotina rotina);

	public void remover(Rotina rotina);

	public List<Rotina> listaRotinasPorPerfil(int id);

	public List<Rotina> findByNomeLike(String nome);

	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil);

}