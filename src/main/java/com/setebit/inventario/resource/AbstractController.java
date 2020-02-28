package com.setebit.inventario.resource;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.setebit.inventario.model.AbstractEntity;
import com.setebit.inventario.response.Response;
import com.setebit.inventario.service.IService;

public abstract class AbstractController<T extends AbstractEntity> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Retornar o serviço da entidade. */
	protected abstract IService<T, Integer> getService();

	@GetMapping()
	public ResponseEntity<Response<List<T>>> find() {
		Response<List<T>> response = new Response<List<T>>();
		response.setData(getService().listAll());
		return ResponseEntity.ok(response);
	}

	@PostMapping()
	public ResponseEntity<Response<T>> create(HttpServletRequest request, @RequestBody T entity, BindingResult result) {
		Response<T> response = new Response<T>();
		try {
			validateUpdate(entity, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			entity = getService().save(entity);
			response.setData(entity);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping()
	public ResponseEntity<Response<T>> update(HttpServletRequest request, @RequestBody T entity, BindingResult result) {
		Response<T> response = new Response<T>();
		try {
			validateUpdate(entity, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			T userPersisted = (T) getService().save(entity);
			response.setData(userPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Integer id) {
		Response<String> response = new Response<String>();
		T user = getService().findOne(id);
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		getService().deleteById(id);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<T>> findById(@PathVariable("id") Integer id) {
		Response<T> response = new Response<T>();
		T user = getService().findOne(id);
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}

	public abstract void validateCreate(T entity, BindingResult result);

	public abstract void validateUpdate(T entity, BindingResult result);

}