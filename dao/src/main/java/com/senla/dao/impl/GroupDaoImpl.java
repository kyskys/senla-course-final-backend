package com.senla.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.dao.api.GroupDao;
import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Group;
import com.senla.entity.Group_;
import com.senla.entity.Pair;
import com.senla.entity.Pair_;
import com.senla.entity.Student;
import com.senla.entity.Timetable;
import com.senla.entity.Timetable_;

@Repository
public class GroupDaoImpl extends SearchableDaoImpl<GroupSearchParams, Group> implements GroupDao {

	public Class<Group> getGenericClass() {
		return Group.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Group_.id);
		sortMap.put(SortParam.NAME, Group_.name);
	}

	@Override
	protected void applyBasicFilters(GroupSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Group> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Group_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Group_.name), like(searchParam.getName())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public List<Group> getGroupsByPairId(Long idPair) {
		List<Group> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			query.where(builder.equal(root.join(Group_.pairs).get(Pair_.id), idPair));
		});
		return result;
	}

	@Override
	public List<Group> getGroupsWithoutPair(Long idPair) {
		List<Group> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			Subquery<Long> subQuery = query.subquery(Long.class);
			Root<Timetable> subRoot = subQuery.from(Timetable.class);
			query.where(builder.not(root.get(Group_.id).in(subQuery.select(subRoot.get(Timetable_.groupId)).where(builder.equal(subRoot.get(Timetable_.pairId), idPair)))));
		});
		return result;
	}

}
