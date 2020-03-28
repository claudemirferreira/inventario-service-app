package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.model.UsuarioPerfil;

public interface UsuarioPerfilService extends BaseService<UsuarioPerfil, Integer> {

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

	public List<UsuarioPerfil> findByUsuario(Usuario usuario);

}