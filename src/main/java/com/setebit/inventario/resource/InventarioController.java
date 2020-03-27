package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.InventarioDTO;
import com.setebit.inventario.model.Inventario;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.InventarioService;

@RestController
@RequestMapping("/api/invetario")
public class InventarioController extends AbstractController<Inventario, Integer, InventarioDTO> {

	@Autowired
	private InventarioService service;

	@Override
	protected BaseService<Inventario, Integer> getService() {
		return service;
	}

	@Override
	protected Class<InventarioDTO> getDtoClass() {
		return InventarioDTO.class;
	}
}
