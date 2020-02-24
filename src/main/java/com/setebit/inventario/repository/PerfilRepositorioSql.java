package com.setebit.inventario.repository;

import java.util.List;

import com.setebit.inventario.model.Perfil;

public interface PerfilRepositorioSql {

	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId);
	
	public Perfil getPerfil(Long id);

}