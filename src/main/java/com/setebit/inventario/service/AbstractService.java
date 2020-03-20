package com.setebit.inventario.service;

import org.springframework.data.repository.CrudRepository;

import com.setebit.inventario.exception.ErrorCode;
import com.setebit.inventario.exception.NotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class AbstractService<T, ID> implements BaseService<T, ID> {

    protected abstract CrudRepository<T, ID> getRepository();

    @Override
    public T getById(ID id) {
        try {
        	Optional<T> product = getRepository().findById(id);
        	return product.get();
		} catch (NotFoundException e) {
			new NotFoundException("Cannot find entity by id: " + id, ErrorCode.OBJECT_NOT_FOUND);
			return null;
		} catch (NoSuchElementException e) {
			new NotFoundException("Cannot find entity by id: " + id, ErrorCode.OBJECT_NOT_FOUND);
			return null;
		}catch (Exception e) {
			new NotFoundException("Cannot find entity by id: " + id, ErrorCode.OBJECT_NOT_FOUND);
			return null;
		}
        
        //
        
        
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getRepository().findAll();
    }
}
