package com.senla.impl.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.LectionDao;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;

@Repository
public class LectionDaoImpl extends SearchableDaoImpl<LectionSearchParams, Lection> implements LectionDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";
	private static final String SORT_PARAM_PAIR_ID = "pair";

	public Class<Lection> getGenericClass() {
		return Lection.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
		sortMap.put(SortParam.PAIR_ID, SORT_PARAM_PAIR_ID);
	}
	
	@Override
	public void removeCourseFromLection(Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set course.id = null where id= :idLection");
		query.setParameter("idLection", idLection);
		query.executeUpdate();
	}

	@Override
	public void removePairFromLection(Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set pair.id = null where id= :idLection");
		query.setParameter("idLection", idLection);
		query.executeUpdate();
	}

	@Override
	public void addCourseToLection(Long idCourse, Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set course.id = :idCourse where id= :idLection");
		query.setParameter("idLection", idLection);
		query.setParameter("idCourse", idCourse);
		query.executeUpdate();
	}

	@Override
	public void addPairToLection(Long idPair, Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set pair.id = :idPair where id= :idLection");
		query.setParameter("idLection", idLection);
		query.setParameter("idPair", idPair);
		query.executeUpdate();
	}

	@Override
	protected void applyFilters(LectionSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Lection> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), like(searchParam.getName())));
		}
		if (searchParam.getPair() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_PAIR_ID), searchParam.getPair()));
		}
	}

}
