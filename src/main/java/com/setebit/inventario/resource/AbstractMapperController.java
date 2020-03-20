package com.setebit.inventario.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setebit.inventario.response.Response;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.util.ObjectMapperUtils;

/**
 *
 * @param <T>   source Entity
 * @param <ID>  Entity's id
 * @param <DTO> DTO object to convert
 */
public abstract class AbstractMapperController<T, ID, DTO> {

	protected abstract BaseService<T, ID> getService();

	protected abstract Class<DTO> getDtoClass();

	@RequestMapping(value = "", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<DTO>>> find() {
		Response<List<DTO>> response = new Response<List<DTO>>();
		response.setData(toDto(getService().getAll()));
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<DTO>> findById(@PathVariable("id") ID id) {
		Response<DTO> response = new Response<DTO>();
		try {
			DTO dto = toDto(getService().getById(id));
			response.setData(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
	}

	private List<DTO> toDto(Collection<T> entityList) {
		return ObjectMapperUtils.mapAll(entityList, getDtoClass());
	}

	private DTO toDto(T entityList) {
		return ObjectMapperUtils.map(entityList, getDtoClass());
	}

}