package com.setebit.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setebit.inventario.model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Integer> {

}
