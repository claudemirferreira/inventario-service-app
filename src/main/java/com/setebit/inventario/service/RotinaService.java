package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.model.Sistema;

public interface RotinaService extends BaseService<Rotina, Integer> {
	
	public List<Rotina> listaRotinasPorPerfil(int id) ;

	public List<Rotina> findByNomeLike(String nome) ;

	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil);

}