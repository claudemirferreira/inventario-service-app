package com.setebit.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Lancamento;
import com.setebit.inventario.repository.LancamentoRepository;
import com.setebit.inventario.service.LancamentoService;

@Service
public class LancamentoServiceImpl extends ServicoImpl<Lancamento, Integer> implements LancamentoService {

	private static final long serialVersionUID = 6281856438650886521L;

	@Autowired
	private LancamentoRepository rep;

	@Override
	protected JpaRepository<Lancamento, Integer> getRepository() {
		return this.rep;
	}

	@Override
	public List<Lancamento> pesquisar(Lancamento entity) {
		// TODO Auto-generated method stub
		return null;
	}

}