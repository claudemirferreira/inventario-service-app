package com.setebit.inventario.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.UsuarioDTO;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.response.Response;
import com.setebit.inventario.service.UsuarioServico;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UsuarioServico service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> create(HttpServletRequest request, @RequestBody Usuario user,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		try {
			validateCreateUsuario(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			user.setSenha(passwordEncoder.encode(user.getSenha()));
			Usuario userPersisted = (Usuario) service.salvar(user);
			response.setData(userPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateCreateUsuario(Usuario user, BindingResult result) {
		if (user.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email no information"));
			return;
		}
	}

	@PutMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> update(HttpServletRequest request, @RequestBody Usuario user,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		try {
			validateUpdate(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			user.setSenha(passwordEncoder.encode(user.getSenha()));
			Usuario userPersisted = (Usuario) service.salvar(user);
			response.setData(userPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateUpdate(Usuario user, BindingResult result) {
		if (user.getId() == 0) {
			result.addError(new ObjectError("Usuario", "Id no information"));
			return;
		}
		if (user.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email no information"));
			return;
		}
	}

	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> findById(@PathVariable("id") String id) {
		Response<Usuario> response = new Response<Usuario>();
		Usuario user = service.findByOne(Long.parseLong(id));
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
		Response<String> response = new Response<String>();
		Usuario user = service.findByOne(Long.parseLong(id));
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		service.remover(user);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<List<Usuario>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<List<Usuario>> response = new Response<List<Usuario>>();
		List<Usuario> users = service.listarTodos();
		response.setData(users);
		return ResponseEntity.ok(response);
	}

	@GetMapping("search")
	public ResponseEntity<Response<List<UsuarioDTO>>> search(
			@RequestParam(value = "nome", required = false, defaultValue = "0") String nome) {
		System.out.println("search");

		Response<List<UsuarioDTO>> response = new Response<List<UsuarioDTO>>();
		List<UsuarioDTO> users = service.findByNomeLike(nome);
		response.setData(users);
		return ResponseEntity.ok(response);

	}

}
