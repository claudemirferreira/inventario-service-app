package com.setebit.inventario.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.service.IService;

public abstract class ServicoImpl<T, ID extends Serializable> implements IService<T, ID>, Serializable {

	private static final long serialVersionUID = -3960905686839773585L;

	protected abstract JpaRepository<T, Integer> getRepository();

	@Override
	public List<T> listAll() {
		return getRepository().findAll();
	}

	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		getRepository().deleteById(id);
	}

	@Override
	public T findOne(Integer id) {
		return (T) getRepository().findById(id);
	}

}