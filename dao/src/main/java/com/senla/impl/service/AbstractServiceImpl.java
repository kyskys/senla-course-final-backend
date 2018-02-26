package com.senla.impl.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.service.AbstractService;
import com.senla.entity.AbstractEntity;

public abstract class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {

	protected abstract AbstractDao<T> getDao();

	@Transactional
	public boolean create(T entity) {
		return getDao().create(entity);
	}

	@Transactional
	public boolean delete(T entity) {
		return getDao().delete(entity);
	}

	@Transactional
	public boolean update(T entity) {
		return getDao().update(entity);
	}

	public T get(Long id) {
		return getDao().get(id);
	}

	public List<T> getAll() {
		return getDao().getAll();
	}

}
