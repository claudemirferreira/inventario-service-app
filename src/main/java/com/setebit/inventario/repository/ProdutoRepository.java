package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.model.Contagem;

public interface ProdutoRepository extends JpaRepository<Contagem, Integer> {

}