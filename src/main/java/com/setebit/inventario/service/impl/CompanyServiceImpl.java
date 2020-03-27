package com.setebit.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.setebit.inventario.model.Company;
import com.setebit.inventario.repository.CompanyRepository;
import com.setebit.inventario.service.CompanyService;

@Service
public class CompanyServiceImpl extends AbstractService<Company, Integer> implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Company, Integer> getRepository() {
        return repository;
    }
}
