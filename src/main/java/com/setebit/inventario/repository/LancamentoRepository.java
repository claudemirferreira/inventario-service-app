package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

}