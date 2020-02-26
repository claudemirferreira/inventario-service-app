package com.setebit.inventario.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.setebit.inventario.model.AbstractEntity;
import com.setebit.inventario.service.IService;

public abstract class AbstractController<T extends AbstractEntity> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Retornar o serviço da entidade. */
	protected abstract IService<T, Integer> getService();

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() {
		return getService().listAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity) {
		return getService().save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") Integer id, @RequestBody T entity) {
		return getService().save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		getService().deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") Integer id) {
		return getService().findOne(id);
	}

}