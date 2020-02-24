package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.setebit.inventario.model.PerfilRotina;

@Repository
public interface PerfilRotinaRepositorio extends JpaRepository<PerfilRotina, Long> {

}