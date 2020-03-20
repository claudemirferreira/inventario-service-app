package com.setebit.inventario.service;

import java.util.List;

public interface BaseService<T, ID> {

    T getById(ID id);

    List<T> getAll();
}