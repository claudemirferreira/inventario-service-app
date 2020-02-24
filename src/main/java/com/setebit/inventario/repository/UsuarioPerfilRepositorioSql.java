package com.setebit.inventario.repository;

import java.util.List;

import com.setebit.inventario.model.Perfil;

public interface UsuarioPerfilRepositorioSql {

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

}