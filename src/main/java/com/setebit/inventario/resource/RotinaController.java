package com.setebit.inventario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.RotinaDTO;
import com.setebit.inventario.response.Response;
import com.setebit.inventario.service.RotinaServico;

@RestController
@RequestMapping("/api/rotina")
@CrossOrigin(origins = "*")
public class RotinaController {

	@Autowired
	private RotinaServico servico;

	@GetMapping(value = "/perfil/{idPerfil}")
	public ResponseEntity<Response<List<RotinaDTO>>> listarPerfilUsuario(@PathVariable("idPerfil") Integer idPerfil) {
		System.out.println("###############listarPerfilUsuario");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> list = RotinaDTO.toDTO(servico.listarRotinaPorPerfil(idPerfil));
		response.setData(list);
		return ResponseEntity.ok(response);

	}

}