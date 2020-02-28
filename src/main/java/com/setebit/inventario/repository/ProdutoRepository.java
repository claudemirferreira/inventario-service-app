package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}