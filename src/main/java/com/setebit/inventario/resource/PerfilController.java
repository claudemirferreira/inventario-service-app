package com.setebit.inventario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.PerfilDTO;
import com.setebit.inventario.dto.RotinaDTO;
import com.setebit.inventario.response.Response;
import com.setebit.inventario.service.PerfilServico;

@RestController
@RequestMapping("/api/perfil")
@CrossOrigin(origins = "*")
public class PerfilController {

	@Autowired
	private PerfilServico perfilServico;

	@GetMapping(value = "/usuario")
	public ResponseEntity<Response<List<PerfilDTO>>> listarPerfilUsuario() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		List<PerfilDTO> list = perfilServico.listarPerfilDto();
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@GetMapping(value = "/")
	public ResponseEntity<Response<List<PerfilDTO>>> listarTodos() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		List<PerfilDTO> list = PerfilDTO.toDTO(perfilServico.listarTodos());
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<PerfilDTO>> listarPerfilRotina(@PathVariable("id") Long idPerfil) {
		System.out.println("###############listarPerfilUsuario");
		Response<PerfilDTO> response = new Response<PerfilDTO>();
		PerfilDTO dto = perfilServico.listarPerfilDto(idPerfil);
		response.setData(dto);
		return ResponseEntity.ok(response);

	}

	@GetMapping(value = "/listarRotinaPorPerfil/{id}")
	public ResponseEntity<Response<List<RotinaDTO>>> listarRotinaPorPerfil(@PathVariable("id") int idPerfil) {
		System.out.println("###############listarRotinaPorPerfil");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> dto = perfilServico.listarRotinaPorPerfil(idPerfil);
		response.setData(dto);
		return ResponseEntity.ok(response);

	}

}