package com.setebit.inventario.service;

import java.util.List;

import com.setebit.inventario.dto.PerfilDTO;
import com.setebit.inventario.dto.RotinaDTO;
import com.setebit.inventario.model.Perfil;

public interface PerfilService extends BaseService<Perfil, Integer> {

	public List<Perfil> findByNomeLike(String nome);

	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId);

	public List<Perfil> listarPerfilUsuario(Integer idSistema, Integer idUsuario);

	public List<Perfil> listarPerfil();

	public List<PerfilDTO> listarPerfilDto();

	public PerfilDTO listarPerfilDto(Long idPerfil);

	public List<RotinaDTO> listarRotinaPorPerfil(int idPerfil);

}