package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Contagem;
import com.setebit.inventario.repository.ContagemRepository;
import com.setebit.inventario.service.ContagemService;

@Service
public class ContagemServiceImpl extends ServicoImpl<Contagem, Integer> implements ContagemService {

	private static final long serialVersionUID = 6281856438650886521L;

	@Autowired
	private ContagemRepository rep;

	@Override
	protected JpaRepository<Contagem, Integer> getRepository() {
		return this.rep;
	}

	@Override
	public List<Contagem> pesquisar(Contagem entity) {
		// TODO Auto-generated method stub
		return null;
	}

}