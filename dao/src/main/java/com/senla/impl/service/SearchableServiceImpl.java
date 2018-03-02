package com.senla.impl.service;

import java.util.List;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.SortParam;
import com.senla.entity.AbstractEntity;

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
