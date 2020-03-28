package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.ProdutoDTO;
import com.setebit.inventario.model.Produto;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends AbstractController<Produto, Integer, ProdutoDTO> {

	@Autowired
	private ProdutoService service;

	@Override
	protected BaseService<Produto, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ProdutoDTO> getDtoClass() {
		return ProdutoDTO.class;
	}
}
