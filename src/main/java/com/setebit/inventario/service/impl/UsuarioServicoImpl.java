package com.setebit.inventario.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.setebit.inventario.dto.UsuarioDTO;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.repository.UsuarioRepositorio;
import com.setebit.inventario.repository.UsuarioRepositorioJPA;
import com.setebit.inventario.security.jwt.JwtUserFactory;
import com.setebit.inventario.service.UsuarioServico;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioRepositorioJPA usuarioRepositorioJPA;

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException {
		return this.usuarioRepositorio.findByLoginAndSenha(login, senha);
	}

	@Override
	public Usuario findByLogin(String login) {
		return this.usuarioRepositorio.findByLogin(login);
	}

	@Override
	public List<Usuario> listarTodos() {
		return this.usuarioRepositorio.findAll();
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return this.usuarioRepositorio.save(usuario);
	}

	@Override
	public void remover(Usuario usuario) {
		this.usuarioRepositorio.delete(usuario);
	}

	@Override
	public List<Usuario> findByUsuario(Usuario usuario) {
		return usuarioRepositorioJPA.findByUsuario(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}

	@Override
	public Usuario findByEmail(String email) {
		return this.usuarioRepositorio.findByEmail(email);
	}

	@Override
	public Usuario findByOne(Long id) {
		return usuarioRepositorio.getOne(id);
	}

	@Override
	public List<UsuarioDTO> findByNomeLike(String nome) {
		return UsuarioDTO.toDTO(usuarioRepositorio.findByNomeLike(nome));
	}

}