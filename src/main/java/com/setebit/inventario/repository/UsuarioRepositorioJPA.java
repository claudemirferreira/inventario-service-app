package com.setebit.inventario.repository;

import java.util.List;

import com.setebit.inventario.model.Usuario;

public interface UsuarioRepositorioJPA {

	List<Usuario> findByUsuario(Usuario usuario);

}