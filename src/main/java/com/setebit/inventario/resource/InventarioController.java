package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.model.Inventario;
import com.setebit.inventario.service.IService;
import com.setebit.inventario.service.impl.InventarioServiceImpl;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController extends AbstractController<Inventario> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private InventarioServiceImpl service;

	@Override
	protected IService<Inventario, Integer> getService() {
		return this.service;
	}

}