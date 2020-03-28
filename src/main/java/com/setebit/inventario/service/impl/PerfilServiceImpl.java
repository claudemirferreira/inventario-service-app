package com.setebit.inventario.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.setebit.inventario.dto.PerfilDTO;
import com.setebit.inventario.dto.RotinaDTO;
import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Rotina;
import com.setebit.inventario.repository.PerfilRepository;
import com.setebit.inventario.repository.PerfilRepositorioSql;
import com.setebit.inventario.repository.PerfilRotinaRepositorioSql;
import com.setebit.inventario.repository.RotinaRepository;
import com.setebit.inventario.security.jwt.JwtUser;
import com.setebit.inventario.service.PerfilService;

@Service
public class PerfilServiceImpl extends AbstractService<Perfil, Integer> implements PerfilService {

	private PerfilRepository repository;

	@Autowired
	private PerfilRepository perfilRepositorio;

	@Autowired
	private PerfilRepositorioSql perfilRepositorioSql;

	@Autowired
	private RotinaRepository rotinaRepositorio;

	@Autowired
	private PerfilRotinaRepositorioSql perfilRotinaRepositorioSql;

	@Autowired
	public PerfilServiceImpl(PerfilRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Perfil, Integer> getRepository() {
		return repository;
	}

	@Override
	public List<Perfil> findByNomeLike(String nome) {
		return this.perfilRepositorio.findByNomeLike(nome);
	}

	@Override
	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId) {
		return this.perfilRepositorioSql.listaPerfilPorSistemaPorUsuario(sistemaId, usuarioId);
	}

	@Override
	public List<Perfil> listarPerfilUsuario(Integer idSistema, Integer idUsuario) {
		return this.perfilRepositorio.listarPerfilUsuario(idSistema, idUsuario);
	}

	@Override
	public List<Perfil> listarPerfil() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return this.perfilRepositorio.listarPerfilUsuario(2, Integer.parseInt(user.getId()));
	}

	public List<PerfilDTO> listarPerfilDto() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Perfil> list = this.perfilRepositorio.listarPerfilUsuario(2, Integer.parseInt(user.getId()));

		List<PerfilDTO> listDto = new ArrayList<PerfilDTO>();
		PerfilDTO dto;
		for (Perfil perfil : list) {
			dto = new PerfilDTO();
			dto = PerfilDTO.toDTO(perfil);
			// TODO seta no codigo do sistema na variavel
			dto.setRotinas(RotinaDTO.toDTO(rotinaRepositorio.findByPerfil(perfil)));
			listDto.add(dto);
		}

		return listDto;
	}

	public PerfilDTO listarPerfilDto(Long idPerfil) {
		Perfil perfil = perfilRepositorioSql.getPerfil(idPerfil);
		PerfilDTO perfilDTO = PerfilDTO.toDTO(perfil);
		perfilDTO.setRotinas(RotinaDTO.toDTO(rotinaRepositorio.findByPerfil(perfil)));
		return perfilDTO;
	}

	@Override
	public List<RotinaDTO> listarRotinaPorPerfil(int idPerfil) {
		List<RotinaDTO> list = RotinaDTO.toDTO(rotinaRepositorio.findAll());
		List<RotinaDTO> dtos = new ArrayList<RotinaDTO>();
		Rotina rotina;
		for (RotinaDTO rotinaDTO : list) {
			try {
				rotina = perfilRotinaRepositorioSql.existeRotinaAssociada(idPerfil, rotinaDTO.getId());
				if (rotina != null)
					rotinaDTO.setChecked(true);

			} catch (Exception e) {
			}
			dtos.add(rotinaDTO);
		}
		return dtos;
	}
}