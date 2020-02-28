package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.model.Produto;
import com.setebit.inventario.service.IService;
import com.setebit.inventario.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends AbstractController<Produto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoService service;

	@Override
	protected IService<Produto, Integer> getService() {
		return this.service;
	}

	@Override
	public void validateCreate(Produto entity, BindingResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void validateUpdate(Produto entity, BindingResult result) {
		// TODO Auto-generated method stub
	}

}