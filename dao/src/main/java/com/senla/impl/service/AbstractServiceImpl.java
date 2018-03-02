package com.senla.impl.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.service.AbstractService;
import com.senla.entity.AbstractEntity;

public abstract class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {

	protected abstract AbstractDao<T> getDao();

	@Transactional
	@Override
	public void create(T entity) {
		getDao().create(entity);
	}

	@Transactional
	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Transactional
	@Override
	public void update(T entity) {
		getDao().update(entity);
	}

	@Override
	public T get(Long id) {
		return getDao().get(id);
	}

	@Override
	public List<T> getAll() {
		return getDao().getAll();
	}
	
	@Override
	public Long count() {
		return getDao().count();
	}
}
