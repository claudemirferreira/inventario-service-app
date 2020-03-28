package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.repository.RotinaRepositorioSql;
import com.setebit.inventario.repository.RotinaRepository;
import com.setebit.inventario.service.RotinaService;

@Service
public class RotinaServiceImpl extends AbstractService<Rotina, Integer> implements RotinaService {

	private RotinaRepository repository;
	
	@Autowired
	private RotinaRepositorioSql rotinaRepositorioSql;

	@Autowired
	public RotinaServiceImpl(RotinaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Rotina, Integer> getRepository() {
		return repository;
	}


	@Override
	public List<Rotina> listaRotinasPorPerfil(int id) {
		return rotinaRepositorioSql.listaRotinasPorPerfil(id);
	}

	@Override
	public List<Rotina> findByNomeLike(String nome) {
		return this.repository.findByNomeLike(nome);
	}

	@Override
	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil) {
		return this.repository.listarRotinaPorPerfil(idPerfil);
	}
}