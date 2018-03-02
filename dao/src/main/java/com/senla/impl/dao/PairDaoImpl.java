package com.senla.impl.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.PairDao;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Pair;

@Repository
public class PairDaoImpl extends SearchableDaoImpl<PairSearchParams, Pair> implements PairDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_DATE = "date";
	private static final String SORT_PARAM_LECTION_ID = "lection";
	private static final String SORT_PARAM_PAIR_TIME = "time";

	public Class<Pair> getGenericClass() {
		return Pair.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.DATE, SORT_PARAM_DATE);
		sortMap.put(SortParam.LECTION_ID, SORT_PARAM_LECTION_ID);
		sortMap.put(SortParam.TIME, SORT_PARAM_PAIR_TIME);
	}

	@Override
	public void addGroupToPair(Long idGroup, Long idPair) {
		Session session = getSession();
		Query query = session.createQuery("update Pair set group.id = :idGroup where id= :idPair");
		query.setParameter("idGroup", idGroup);
		query.setParameter("idPair", idPair);
		query.executeUpdate();
	}

	@Override
	protected void applyFilters(PairSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Pair> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getDate() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_DATE), searchParam.getDate()));
		}
		if (searchParam.getLection() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_LECTION_ID), searchParam.getLection()));
		}
		if (searchParam.getTime() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_PAIR_TIME), searchParam.getTime()));
		}
	}

}
