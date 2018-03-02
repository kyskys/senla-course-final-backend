package com.senla.impl.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.LecturerDao;
import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course;
import com.senla.entity.Lecturer;

@Repository
public class LecturerDaoImpl extends SearchableDaoImpl<LecturerSearchParams, Lecturer> implements LecturerDao {
	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";
	private static final String SORT_PARAM_EMAIL = "email";
	private static final String SORT_PARAM_PHONE_NUMBER = "number";

	public Class<Lecturer> getGenericClass() {
		return Lecturer.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
		sortMap.put(SortParam.EMAIL, SORT_PARAM_EMAIL);
		sortMap.put(SortParam.PHONE_NUMBER, SORT_PARAM_PHONE_NUMBER);
	}

	@Override
	public void addCourseToLecturer(Long idCourse, Long idLecturer) {
		Session session = getSession();
		Query query = session.createQuery("update Course set lecturer.id = :idLecturer where id= :idCourse");
		query.setParameter("idLecturer", idLecturer);
		query.setParameter("idCourse", idCourse);
		query.executeUpdate();
	}

	@Override
	public List<Course> getCoursesByLecturerId(Long idLecturer) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Course> query = builder.createQuery(Course.class);
		Root<Course> root = query.from(Course.class);
		query.select(root).where(builder.equal(root.get("lecturer"), idLecturer));
		TypedQuery<Course> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	protected void applyFilters(LecturerSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Lecturer> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), like(searchParam.getName())));
		}
		if (searchParam.getEmail() != null) {
			query.where(builder.like(root.get(SORT_PARAM_EMAIL), like(searchParam.getEmail())));
		}
		if (searchParam.getNumber() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_PHONE_NUMBER), searchParam.getNumber()));
		}
	}

}
