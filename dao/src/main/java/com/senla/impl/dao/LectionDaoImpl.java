package com.senla.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.LectionDao;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course_;
import com.senla.entity.Lection;
import com.senla.entity.Lection_;
import com.senla.entity.Pair_;

@Repository
public class LectionDaoImpl extends SearchableDaoImpl<LectionSearchParams, Lection> implements LectionDao {

	public Class<Lection> getGenericClass() {
		return Lection.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Lection_.id);
		sortMap.put(SortParam.NAME, Lection_.name);
		sortMap.put(SortParam.PAIR_ID, Lection_.pair);
		sortMap.put(SortParam.COURSE_ID, Lection_.course);
	}

	@Override
	public void removePairFromLection(Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set pair.id = null where id= :idLection");
		query.setParameter("idLection", idLection);
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
	protected void applyBasicFilters(LectionSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Lection> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Lection_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Lection_.name), like(searchParam.getName())));
		}
		if (searchParam.getPair() != null) {
			predicates.add(builder.like(root.join(Lection_.pair).get(Pair_.name), like(searchParam.getPair())));
		}
		if (searchParam.getCourse() != null) {
			predicates.add(builder.like(root.join(Lection_.course).get(Course_.name), like(searchParam.getCourse())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public List<Lection> getLectionsByCourseId(Long idCourse) {
		List<Lection> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			if (idCourse != null) {
				query.where(builder.equal(root.join(Lection_.course).get(Course_.id), idCourse));
			}
		});
		return result;
	}

	@Override
	public List<Lection> getLectionsWithoutCourse() {
		List<Lection> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			query.where(builder.isNull(root.get(Lection_.course)));
		});
		return result;
	}

}
