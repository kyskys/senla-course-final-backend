package com.senla.api.dao;

import java.util.List;

import com.senla.dao.util.SortParam;
import com.senla.entity.AbstractEntity;

public interface SearchableDao<T, R extends AbstractEntity> {
	List<R> search(SortParam sortParam, T searchParam, int limit, int offset);
}
