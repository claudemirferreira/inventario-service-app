package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.repository.UsuarioRepositorioJPA;
import com.setebit.inventario.repository.UsuarioRepository;
import com.setebit.inventario.security.jwt.JwtUserFactory;
import com.setebit.inventario.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends AbstractService<Usuario, Integer>
		implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioRepositorioJPA usuarioRepositorioJPA;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Usuario, Integer> getRepository() {
		return repository;
	}

	@Override
	public Usuario findByLogin(String login) {
		return this.repository.findByLogin(login);
	}

	@Override
	public List<Usuario> findByUsuario(Usuario usuario) {
		return usuarioRepositorioJPA.findByUsuario(usuario);
	}

	@Override
	public Usuario findByEmail(String email) {
		return this.repository.findByEmail(email);
	}

	@Override
	public Usuario findByOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public List<Usuario> findByNomeLike(String nome) {
		return repository.findByNomeLike(nome);
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repository.findByLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", login));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}

}