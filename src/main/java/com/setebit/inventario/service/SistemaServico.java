package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Sistema;

public interface SistemaServico {

	public List<Sistema> listarTodos();

	public Sistema salvar(Sistema sistema);

	public void remover(Sistema sistema);

	public List<Sistema> findByNomeLike(String nome);

	public Sistema findByCodigo(String codigo);

}