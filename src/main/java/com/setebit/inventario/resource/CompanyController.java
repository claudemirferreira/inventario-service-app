package com.setebit.inventario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setebit.inventario.dto.CompanyDto;
import com.setebit.inventario.model.Company;
import com.setebit.inventario.service.BaseService;
import com.setebit.inventario.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController extends AbstractMapperController<Company, Integer, CompanyDto> {

    @Autowired
    private CompanyService service;

    @Override
    protected BaseService<Company, Integer> getService() {
        return service;
    }

    @Override
    protected Class<CompanyDto> getDtoClass() {
        return CompanyDto.class;
    }
}
