package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.PerfilRotina;
import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.repository.PerfilRotinaRepositorio;
import com.setebit.inventario.repository.PerfilRotinaRepositorioSql;
import com.setebit.inventario.service.PerfilRotinaServico;

@Service
public class PerfilRotinaServicoImpl implements PerfilRotinaServico {

	@Autowired
	private PerfilRotinaRepositorio repositorio;

	@Autowired
	private PerfilRotinaRepositorioSql repositorioSql;

	@Override
	public List<PerfilRotina> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public PerfilRotina salvar(PerfilRotina perfilRotina) {
		return repositorio.save(perfilRotina);
	}

	@Override
	public void remover(PerfilRotina perfilRotina) {
		this.repositorio.delete(perfilRotina);
	}

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil) {
		return repositorioSql.listaRotinaNotInPerfil(idPerfil);
	}

}
