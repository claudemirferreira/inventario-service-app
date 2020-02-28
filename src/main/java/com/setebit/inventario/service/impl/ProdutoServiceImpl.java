package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Produto;
import com.setebit.inventario.repository.ProdutoRepository;
import com.setebit.inventario.service.ProdutoService;

@Service
public class ProdutoServiceImpl extends ServicoImpl<Produto, Integer> implements ProdutoService {

	private static final long serialVersionUID = 6281856438650886521L;

	@Autowired
	private ProdutoRepository rep;

	@Override
	protected JpaRepository<Produto, Integer> getRepository() {
		return this.rep;
	}

	@Override
	public List<Produto> pesquisar(Produto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}