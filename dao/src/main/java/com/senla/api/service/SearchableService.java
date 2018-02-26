package com.senla.api.service;

import java.util.List;

import com.senla.api.dao.SearchableDao;
import com.senla.dao.util.SortParam;
import com.senla.entity.AbstractEntity;

public interface SearchableService<T, R extends AbstractEntity> {
	SearchableDao<T, R> getSearchableDao();

	List<R> search(SortParam sortParam, T searchParam, int limit, int offset);
}
