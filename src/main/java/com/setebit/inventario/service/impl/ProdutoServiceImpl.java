package com.setebit.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Produto;
import com.setebit.inventario.repository.ProdutoRepository;
import com.setebit.inventario.service.ProdutoService;

@Service
public class ProdutoServiceImpl extends AbstractService<Produto, Integer> implements ProdutoService {

	private ProdutoRepository repository;

	@Autowired
	public ProdutoServiceImpl(ProdutoRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Produto, Integer> getRepository() {
		return repository;
	}

}