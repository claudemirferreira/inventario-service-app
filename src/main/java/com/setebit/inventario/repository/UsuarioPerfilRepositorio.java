package com.setebit.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.setebit.inventario.model.Perfil;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.model.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositorio extends JpaRepository<UsuarioPerfil, Long> {

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario "
			+ " and up.usuarioPerfilPk.perfil = :perfil ")
	public UsuarioPerfil findByUsuarioAndPerfil(@Param("usuario") Usuario usuario, @Param("perfil") Perfil perfil);

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario ")
	public List<UsuarioPerfil> findByUsuario(@Param("usuario") Usuario usuario);

}