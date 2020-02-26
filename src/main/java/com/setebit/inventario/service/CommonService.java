package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.AbstractEntity;

public interface CommonService<E extends AbstractEntity> {

	E save(E entity);

	List<E> findAll();

	E getOne(Integer id);

	void deleteById(Integer id);

}