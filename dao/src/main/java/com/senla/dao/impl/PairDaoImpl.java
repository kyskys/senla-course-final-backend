package com.senla.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.dao.api.PairDao;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Group_;
import com.senla.entity.Lection_;
import com.senla.entity.Pair;
import com.senla.entity.PairTime_;
import com.senla.entity.Pair_;

@Repository
public class PairDaoImpl extends SearchableDaoImpl<PairSearchParams, Pair> implements PairDao {

	public Class<Pair> getGenericClass() {
		return Pair.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Pair_.id);
		sortMap.put(SortParam.DATE, Pair_.date);
		sortMap.put(SortParam.LECTION_ID, Pair_.lection);
		sortMap.put(SortParam.TIME, Pair_.time);
	}

	@Override
	protected void applyBasicFilters(PairSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Pair> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Pair_.id), searchParam.getId()));
		}
		if (searchParam.getDate() != null) {
			predicates.add(builder.equal(root.get(Pair_.date), searchParam.getDate()));
		}
		if (searchParam.getLection() != null) {
			predicates.add(builder.like(root.join(Pair_.lection).get(Lection_.name), like(searchParam.getLection())));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Pair_.name), like(searchParam.getName())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public List<Pair> getPairsByGroupId(Long idGroup) {
		List<Pair> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			if (idGroup != null) {
				query.where(builder.equal(root.join(Pair_.groups).get(Group_.id), idGroup));
			}
		});
		return result;
	}

	@Override
	public List<Pair> getPairsByWeek(LocalDateTime startOfWeek, Long idGroup) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Pair> query = builder.createQuery(Pair.class);
		Root<Pair> root = query.from(Pair.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (idGroup != null) {
			predicates.add(builder.equal(root.join(Pair_.groups).get(Group_.id), idGroup));
		}
		if (startOfWeek != null) {
			predicates.add(builder.and(builder.greaterThan(root.get(Pair_.date), startOfWeek),
					builder.lessThan(root.get(Pair_.date), startOfWeek.plusDays(7))));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(builder.asc(root.get(Pair_.date)),
				builder.asc(root.join(Pair_.time).get(PairTime_.startTime)));
		TypedQuery<Pair> result = session.createQuery(query);
		return result.getResultList();
	}

}
