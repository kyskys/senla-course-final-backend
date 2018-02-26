package com.senla.impl.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.CourseDao;
import com.senla.api.dao.SearchableDao;
import com.senla.dao.util.CourseSearchParam;
import com.senla.dao.util.SortParam;
import com.senla.entity.Course;

@Repository
public class CourseDaoImpl extends SearchableDaoImpl<Course>
		implements CourseDao, SearchableDao<CourseSearchParam, Course> {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";
	private static final String SORT_PARAM_LECTURER = "lecturer";

	@Override
	void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
		sortMap.put(SortParam.LECTURER_ID, SORT_PARAM_LECTURER);
	}

	public Class<Course> getGenericClass() {
		return Course.class;
	}

	@Override
	public List<Course> search(SortParam sortParam, CourseSearchParam searchParam, int limit, int offset) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Course> query = builder.createQuery(getGenericClass());
		Root<Course> root = query.from(Course.class);
		query.select(root);
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), searchParam.getName()));
		}
		if (searchParam.getLecturer() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_LECTURER), searchParam.getLecturer()));
		}
		if (sortParam != null && sortMap.get(sortParam) != null) {
			query.orderBy(builder.asc(root.get(sortMap.get(sortParam))));
		} else {
			query.orderBy(builder.asc(root.get(SORT_PARAM_ID)));
		}
		TypedQuery<Course> result = session.createQuery(query);
		return result.getResultList();
	}

}
