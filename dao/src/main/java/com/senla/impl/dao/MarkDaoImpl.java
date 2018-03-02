package com.senla.impl.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.MarkDao;
import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Mark;

@Repository
public class MarkDaoImpl extends SearchableDaoImpl<MarkSearchParams, Mark> implements MarkDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_PAIR = "pair";
	private static final String SORT_PARAM_STUDENT = "student";

	public Class<Mark> getGenericClass() {
		return Mark.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.PAIR_ID, SORT_PARAM_PAIR);
		sortMap.put(SortParam.STUDENT_ID, SORT_PARAM_STUDENT);
	}

	@Override
	public void addPairToMark(Long idPair, Long idMark) {
		Session session = getSession();
		Query query = session.createQuery("update Mark set pair.id = :idPair where id= :idMark");
		query.setParameter("idPair", idPair);
		query.setParameter("idMark", idMark);
		query.executeUpdate();
	}

	@Override
	public void addStudentToMark(Long idStudent, Long idMark) {
		Session session = getSession();
		Query query = session.createQuery("update Mark set student.id = :idStudent where id= :idMark");
		query.setParameter("idStudent", idStudent);
		query.setParameter("idMark", idMark);
		query.executeUpdate();
	}

	@Override
	protected void applyFilters(MarkSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Mark> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getPair() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_PAIR), searchParam.getPair()));
		}
		if (searchParam.getStudent() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_STUDENT), searchParam.getStudent()));
		}
	}

}
