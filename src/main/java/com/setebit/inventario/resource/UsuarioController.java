package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.UsuarioDTO;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends AbstractController<Usuario, Integer, UsuarioDTO> {

	@Autowired
	private UsuarioService service;

	@Override
	protected BaseService<Usuario, Integer> getService() {
		return service;
	}

	@Override
	protected Class<UsuarioDTO> getDtoClass() {
		return UsuarioDTO.class;
	}
}
