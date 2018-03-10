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
import com.senla.api.dao.PairDao;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.SortParam;
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
	
	//TODO ybrat metod addMarkToPair
	/*@Override
	public void addMarkToPair(Long idMark, Long idPair) {
		Session session = getSession();
		Query query = session.createQuery("update Mark set pair.id = :idPair where id= :idMark");
		query.setParameter("idMark", idMark);
		query.setParameter("idPair", idPair);
		query.executeUpdate();
	}*/

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
		if (searchParam.getStartTime() != null) {
			predicates.add(builder.equal(root.join(Pair_.time).get(PairTime_.startTime), searchParam.getStartTime()));
		}
		if (searchParam.getEndTime() != null) {
			predicates.add(builder.equal(root.join(Pair_.time).get(PairTime_.endTime), searchParam.getEndTime()));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

}
