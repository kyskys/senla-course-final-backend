package com.senla.api.service;

import java.util.List;

import com.senla.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {

	void create(T entity);

	void delete(T entity);

	void update(T entity);

	T get(Long id);

	List<T> getAll();
	
	Long count();
}
