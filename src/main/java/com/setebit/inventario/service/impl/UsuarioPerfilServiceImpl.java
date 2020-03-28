package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.model.UsuarioPerfil;
import com.setebit.inventario.repository.UsuarioPerfilRepositorioSql;
import com.setebit.inventario.repository.UsuarioPerfilRepository;
import com.setebit.inventario.service.UsuarioPerfilService;

@Service
public class UsuarioPerfilServiceImpl extends AbstractService<UsuarioPerfil, Integer> implements UsuarioPerfilService {

	@Autowired
	private UsuarioPerfilRepository repository;

	@Autowired
	private UsuarioPerfilRepositorioSql repositorioSql;

	@Autowired
	public UsuarioPerfilServiceImpl(UsuarioPerfilRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<UsuarioPerfil, Integer> getRepository() {
		return repository;
	}

	@Override
	public List<Perfil> listaPerfilNotInUsuario(int idUsuario) {
		return repositorioSql.listaPerfilNotInUsuario(idUsuario);
	}

	@Override
	public List<UsuarioPerfil> findByUsuario(Usuario usuario) {
		return repository.findByUsuario(usuario);
	}
}
