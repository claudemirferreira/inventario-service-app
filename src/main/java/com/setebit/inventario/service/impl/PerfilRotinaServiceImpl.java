package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.PerfilRotina;
import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.repository.PerfilRotinaRepositorioSql;
import com.setebit.inventario.repository.PerfilRotinaRepository;
import com.setebit.inventario.service.PerfilRotinaService;

@Service
public class PerfilRotinaServiceImpl extends AbstractService<PerfilRotina, Integer> implements PerfilRotinaService {

	@Autowired
	private PerfilRotinaRepositorioSql repositorioSql;

	@Autowired
	private PerfilRotinaRepository repository;

	@Autowired
	public PerfilRotinaServiceImpl(PerfilRotinaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<PerfilRotina, Integer> getRepository() {
		return repository;
	}

	public List<Rotina> listaRotinaNotInPerfil(Integer idPerfil) {
		return repositorioSql.listaRotinaNotInPerfil(idPerfil);
	}

}
