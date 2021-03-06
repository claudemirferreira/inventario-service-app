package com.setebit.inventario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.setebit.inventario.service.BaseService;

public abstract class AbstractService<T, ID> implements BaseService<T, ID> {

	protected abstract CrudRepository<T, ID> getRepository();

	@Override
	public T findById(ID id) {
		try {
			Optional<T> product = getRepository().findById(id);
			return product.get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<T> findAll() {
		return (List<T>) getRepository().findAll();
	}

	@Override
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public long count() {
		return getRepository().count();
	}

	public boolean existsById(ID id) {
		return getRepository().existsById(id);
	}

	public T save(T entity) {
		return getRepository().save(entity);

	}

	public Iterable<T> saveAll(List<T> list) {
		return getRepository().saveAll(list);
	}

	public Iterable<T> findAllById(Iterable<ID> ids) {
		return getRepository().findAllById(ids);
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}

}