package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.LancamentoDTO;
import com.setebit.inventario.model.Lancamento;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController extends AbstractController<Lancamento, Integer, LancamentoDTO> {

	@Autowired
	private LancamentoService service;

	@Override
	protected BaseService<Lancamento, Integer> getService() {
		return service;
	}

	@Override
	protected Class<LancamentoDTO> getDtoClass() {
		return LancamentoDTO.class;
	}
}
