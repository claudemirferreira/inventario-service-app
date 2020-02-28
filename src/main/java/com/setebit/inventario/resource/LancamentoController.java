package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.model.Lancamento;
import com.setebit.inventario.service.IService;
import com.setebit.inventario.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController extends AbstractController<Lancamento> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LancamentoService service;

	@Override
	protected IService<Lancamento, Integer> getService() {
		return this.service;
	}

	@Override
	public void validateCreate(Lancamento entity, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(Lancamento entity, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

}