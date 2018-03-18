package com.senla.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.SortParam;
import com.senla.entity.AbstractEntity;

@Transactional
public abstract class SearchableServiceImpl<T, R extends AbstractEntity> extends AbstractServiceImpl<R>
		implements Searchable<T, R> {

	@Override
	public List<R> search(SortParam sortParam, T searchParam, int limit, int offset, boolean asc) {
		return getSearchableDao().search(sortParam, searchParam, limit, offset, asc);
	}

	protected abstract Searchable<T, R> getSearchableDao();

	@Override
	public Long count(T searchParam) {
		return getSearchableDao().count(searchParam);
	}
	
}
