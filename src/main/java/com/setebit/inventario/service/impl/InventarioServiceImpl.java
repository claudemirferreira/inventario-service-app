package com.setebit.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Inventario;
import com.setebit.inventario.repository.InventarioRepository;
import com.setebit.inventario.service.InventarioService;

@Service
public class InventarioServiceImpl extends AbstractService<Inventario, Integer> implements InventarioService {

	private InventarioRepository repository;

	@Autowired
	public InventarioServiceImpl(InventarioRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Inventario, Integer> getRepository() {
		return repository;
	}

}