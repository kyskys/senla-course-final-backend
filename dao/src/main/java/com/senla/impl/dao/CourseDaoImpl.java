package com.senla.impl.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.api.dao.CourseDao;
import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course;
import com.senla.entity.Lection;

@Repository
public class CourseDaoImpl extends SearchableDaoImpl<CourseSearchParams, Course> implements CourseDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";
	private static final String SORT_PARAM_LECTURER = "lecturer";

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
		sortMap.put(SortParam.LECTURER_ID, SORT_PARAM_LECTURER);
	}

	public Class<Course> getGenericClass() {
		return Course.class;
	}

	@Override
	public void addLectionToCourse(Long idLection, Long idCourse) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set course.id = :idCourse where id= :idLection");
		query.setParameter("idLection", idLection);
		query.setParameter("idCourse", idCourse);
		query.executeUpdate();
	}

	@Override
	public void removeLectionFromCourse(Long idLection) {
		Session session = getSession();
		Query query = session.createQuery("update Lection set course.id = null where id= :idLection");
		query.setParameter("idLection", idLection);
		query.executeUpdate();
	}

	@Override
	public List<Lection> getLectionsByCourseId(Long idCourse) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lection> query = builder.createQuery(Lection.class);
		Root<Lection> root = query.from(Lection.class);
		query.select(root).where(builder.equal(root.get("course"), idCourse));
		TypedQuery<Lection> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	protected void applyFilters(CourseSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder, Root<Course> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), like(searchParam.getName())));
		}
		if (searchParam.getLecturer() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_LECTURER), searchParam.getLecturer()));
		}
	}

}
