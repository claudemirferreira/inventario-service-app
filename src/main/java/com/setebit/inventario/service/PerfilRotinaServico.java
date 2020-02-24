package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.PerfilRotina;
import com.setebit.inventario.model.Rotina;

public interface PerfilRotinaServico {

	public List<PerfilRotina> listarTodos();

	public PerfilRotina salvar(PerfilRotina usuarioPerfil);

	public void remover(PerfilRotina usuarioPerfil);

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil);

}
