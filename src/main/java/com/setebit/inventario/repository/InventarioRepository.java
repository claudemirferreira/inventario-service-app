package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}