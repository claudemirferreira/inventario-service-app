package com.setebit.inventario.service;

import java.io.Serializable;
import java.util.List;

public interface IService<T, ID extends Serializable> {

	public List<T> listAll();

	public T findOne(Integer id);

	public List<T> pesquisar(T entity);

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Integer id);

}