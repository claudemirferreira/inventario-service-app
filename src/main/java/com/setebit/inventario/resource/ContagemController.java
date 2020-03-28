package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.ContagemDTO;
import com.setebit.inventario.model.Contagem;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.ContagemService;

@RestController
@RequestMapping("/api/contagem")
public class ContagemController extends AbstractController<Contagem, Integer, ContagemDTO> {

	@Autowired
	private ContagemService service;

	@Override
	protected BaseService<Contagem, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ContagemDTO> getDtoClass() {
		return ContagemDTO.class;
	}
}
