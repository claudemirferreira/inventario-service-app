package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.model.UsuarioPerfil;
import com.setebit.inventario.repository.UsuarioPerfilRepositorio;
import com.setebit.inventario.repository.UsuarioPerfilRepositorioSql;
import com.setebit.inventario.service.UsuarioPerfilServico;

@Service
public class UsuarioPerfilServicoImpl implements UsuarioPerfilServico {

	@Autowired
	private UsuarioPerfilRepositorio repositorio;

	@Autowired
	private UsuarioPerfilRepositorioSql repositorioSql;

	@Override
	public List<UsuarioPerfil> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public UsuarioPerfil salvar(UsuarioPerfil usuarioPerfil) {
		return this.repositorio.save(usuarioPerfil);
	}

	@Override
	public void remover(UsuarioPerfil usuarioPerfil) {
		this.repositorio.delete(usuarioPerfil);

	}

	@Override
	public List<Perfil> listaPerfilNotInUsuario(int idUsuario) {
		return repositorioSql.listaPerfilNotInUsuario(idUsuario);
	}

	@Override
	public List<UsuarioPerfil> findByUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}
}
