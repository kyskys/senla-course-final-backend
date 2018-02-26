package com.senla.impl.service;

import java.util.List;

import com.senla.api.dao.SearchableDao;
import com.senla.api.service.SearchableService;
import com.senla.dao.util.SortParam;
import com.senla.entity.AbstractEntity;

public abstract class SearchableServiceImpl<T extends AbstractEntity, R> extends AbstractServiceImpl<T>
		implements SearchableService<R, T> {

	@Override
	public List<T> search(SortParam sortParam, R searchParam, int limit, int offset) {
		return getSearchableDao().search(sortParam, searchParam, limit, offset);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SearchableDao<R, T> getSearchableDao() {
		return (SearchableDao<R, T>) getDao();
	}

}
