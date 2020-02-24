package com.setebit.inventario.repository;

import java.util.List;

import com.setebit.inventario.model.Rotina;

public interface PerfilRotinaRepositorioSql {

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil);

	public Rotina existeRotinaAssociada(int idPerfil, int idRotina);

}