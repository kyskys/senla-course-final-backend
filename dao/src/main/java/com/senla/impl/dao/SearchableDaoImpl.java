package com.senla.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.SortParam;
import com.senla.entity.AbstractEntity;

public abstract class SearchableDaoImpl<R, T extends AbstractEntity> extends AbstractDaoImpl<T>
		implements Searchable<R, T> {

	{
		sortMap = new HashMap<SortParam, String>();
		initSortMap();
	}

	protected Map<SortParam, String> sortMap;

	protected abstract void initSortMap();

	protected String like(String str) {
		return String.format("%%%s%%", str);
	}

	protected void orderQuery(Path<?> root, CriteriaBuilder builder, CriteriaQuery<?> query, boolean asc) {
		if (asc) {
			query.orderBy(builder.asc(root));
		} else {
			query.orderBy(builder.desc(root));
		}
	}

	@Override
	public Long count(R searchParam) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<T> root = query.from(getGenericClass());
		query.select(builder.count(root));
		applyFilters(searchParam, query, builder, root);
		TypedQuery<Long> result = session.createQuery(query);
		return result.getSingleResult();
	}

	@Override
	public List<T> search(SortParam sortParam, R searchParam, int limit, int offset, boolean asc) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		applyFilters(searchParam, query, builder, root);
		String param = sortMap.get(sortParam);
		orderQuery(root.get(param != null ? param : getDefSortValue()), builder, query, asc);
		TypedQuery<T> result = session.createQuery(query).setMaxResults(limit).setFirstResult(offset);
		return result.getResultList();
	}

	protected String getDefSortValue() {
		return "id";
	}

	protected abstract void applyFilters(R searchParam, CriteriaQuery<?> query, CriteriaBuilder builder, Root<T> root);
}
