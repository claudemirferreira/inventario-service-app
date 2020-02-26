package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Inventario;
import com.setebit.inventario.repository.InventarioRepository;
import com.setebit.inventario.service.InventarioService;

@Service
public class InventarioServiceImpl extends ServicoImpl<Inventario, Integer> implements InventarioService {

	private static final long serialVersionUID = 6281856438650886521L;

	@Autowired
	private InventarioRepository rep;

	@Override
	protected JpaRepository<Inventario, Integer> getRepository() {
		return this.rep;
	}

	@Override
	public List<Inventario> pesquisar(Inventario entity) {
		// TODO Auto-generated method stub
		return null;
	}

}