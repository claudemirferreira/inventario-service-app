package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.model.PerfilRotina;
import com.setebit.inventario.model.Rotina;

public interface PerfilRotinaService extends BaseService<PerfilRotina, Integer> {

	public List<Rotina> listaRotinaNotInPerfil(Integer idPerfil);

}
