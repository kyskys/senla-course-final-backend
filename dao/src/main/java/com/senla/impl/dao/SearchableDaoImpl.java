package com.senla.impl.dao;

import java.util.Map;

import com.senla.dao.util.SortParam;
import com.senla.entity.AbstractEntity;

public abstract class SearchableDaoImpl<T extends AbstractEntity> extends AbstractDaoImpl<T> {
	
	{
		initSortMap();
	}

	protected Map<SortParam, String> sortMap;

	abstract void initSortMap();
}
