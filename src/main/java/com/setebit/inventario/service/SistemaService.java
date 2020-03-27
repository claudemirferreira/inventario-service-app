package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Sistema;

public interface SistemaService extends BaseService<Sistema, Integer> {

	public List<Sistema> findByNomeLike(String nome);

	public Sistema findByCodigo(String codigo);

}