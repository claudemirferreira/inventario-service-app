package com.setebit.inventario.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.setebit.inventario.model.Usuario;

@Component
public interface UsuarioService extends BaseService<Usuario, Integer> {

	public Usuario findByLogin(String login);

	public List<Usuario> findByUsuario(Usuario usuario);

	public Usuario findByEmail(String email);

	public Usuario findByOne(Integer id);

	public List<Usuario> findByNomeLike(String nome);

}