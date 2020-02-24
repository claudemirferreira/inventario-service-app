package com.setebit.inventario.repository;

import java.util.List;

import com.setebit.inventario.model.Rotina;

public interface RotinaRepositorioSql {

	public List<Rotina> listaRotinasPorPerfil(int id);

}