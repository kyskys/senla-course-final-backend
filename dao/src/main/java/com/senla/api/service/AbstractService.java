package com.senla.api.service;

import java.util.List;

import com.senla.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {

	boolean create(T entity);

	boolean delete(T entity);

	boolean update(T entity);

	T get(Long id);

	List<T> getAll();
}
