package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.model.Contagem;
import com.setebit.inventario.service.ContagemService;
import com.setebit.inventario.service.IService;

@RestController
@RequestMapping("/api/contagem")
public class ContagemController extends AbstractController<Contagem> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ContagemService service;

	@Override
	protected IService<Contagem, Integer> getService() {
		return this.service;
	}

	@Override
	public void validateCreate(Contagem entity, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(Contagem entity, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

}