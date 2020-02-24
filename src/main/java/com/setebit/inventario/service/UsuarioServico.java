package com.setebit.inventario.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.setebit.inventario.dto.UsuarioDTO;
import com.setebit.inventario.model.Usuario;

@Component
public interface UsuarioServico extends UserDetailsService {

	public List<Usuario> listarTodos();

	public Usuario salvar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario findByLogin(String login);

	public Usuario findByEmail(String email);

	public Usuario findByOne(Long id);

	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException;

	public List<Usuario> findByUsuario(Usuario usuario) throws NoResultException;

	public List<UsuarioDTO> findByNomeLike(String nome);

}
