package com.senla.impl.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.GroupDao;
import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;

@Repository
public class GroupDaoImpl extends SearchableDaoImpl<GroupSearchParams, Group> implements GroupDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";

	public Class<Group> getGenericClass() {
		return Group.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
	}

	@Override
	public List<Pair> getPairsByGroupId(Long idGroup) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Pair> query = builder.createQuery(Pair.class);
		Root<Pair> root = query.from(Pair.class);
		query.select(root).where(builder.equal(root.get("pair"), idGroup));
		TypedQuery<Pair> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	public List<Student> getStudentsByGroupId(Long idGroup) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root).where(builder.equal(root.get("student"), idGroup));
		TypedQuery<Student> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	public void addStudentToGroup(Long idStudent, Long idGroup) {
		Session session = getSession();
		Query query = session.createQuery("update Student set group.id = :idGroup where id= :idStudent");
		query.setParameter("idStudent", idStudent);
		query.setParameter("idGroup", idGroup);
		query.executeUpdate();
	}

	@Override
	public void removeStudentFromGroup(Long idStudent) {
		Session session = getSession();
		Query query = session.createQuery("update Student set group.id = null where id= :idStudent");
		query.setParameter("idStudent", idStudent);
		query.executeUpdate();
	}

	@Override
	protected void applyFilters(GroupSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Group> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), like(searchParam.getName())));
		}
	}

}
