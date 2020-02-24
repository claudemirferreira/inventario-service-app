package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.model.UsuarioPerfil;

public interface UsuarioPerfilServico {

	public List<UsuarioPerfil> listarTodos();

	public UsuarioPerfil salvar(UsuarioPerfil usuarioPerfil);

	public void remover(UsuarioPerfil usuarioPerfil);

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

	public List<UsuarioPerfil> findByUsuario(Usuario usuario);
}