package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.RotinaDTO;
import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.RotinaService;

@RestController
@RequestMapping("/api/rotina")
public class RotinaController extends AbstractController<Rotina, Integer, RotinaDTO> {

	@Autowired
	private RotinaService service;

	@Override
	protected BaseService<Rotina, Integer> getService() {
		return service;
	}

	@Override
	protected Class<RotinaDTO> getDtoClass() {
		return RotinaDTO.class;
	}
}
