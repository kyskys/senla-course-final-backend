package com.senla.api.dao;

import java.util.List;

import com.senla.entity.AbstractEntity;
import com.senla.entity.util.DictionaryItem;

public interface AbstractDao<T extends AbstractEntity> {

	Class<T> getGenericClass();

	T create(T entity);

	void delete(T entity);

	void update(T entity);

	T get(Long id);

	List<T> getAll();
	
	Long count();
	
	List<DictionaryItem> getDictionary();

}
