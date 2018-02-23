package com.senla.api.dao;

import java.util.List;

import com.senla.entity.AbstractEntity;

public interface AbstractDao<T extends AbstractEntity> {

	Class<T> getGenericClass();

	boolean create(T entity);

	boolean delete(T entity);

	boolean update(T entity);

	T get(Long id);

	List<T> getAll();
}
