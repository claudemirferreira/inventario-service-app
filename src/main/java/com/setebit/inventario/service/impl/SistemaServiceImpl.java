package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Sistema;
import com.setebit.inventario.repository.SistemaRepository;
import com.setebit.inventario.service.SistemaService;

@Service
public class SistemaServiceImpl extends AbstractService<Sistema, Integer> implements SistemaService {

	private SistemaRepository repository;

	@Autowired
	public SistemaServiceImpl(SistemaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Sistema, Integer> getRepository() {
		return repository;
	}

	@Override
	public List<Sistema> findByNomeLike(String nome) {
		return repository.findByNomeLike(nome);
	}

	@Override
	public Sistema findByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

}