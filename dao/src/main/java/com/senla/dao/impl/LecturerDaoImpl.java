package com.senla.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.dao.api.LecturerDao;
import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course;
import com.senla.entity.Course_;
import com.senla.entity.Lecturer;
import com.senla.entity.Lecturer_;

@Repository
public class LecturerDaoImpl extends SearchableDaoImpl<LecturerSearchParams, Lecturer> implements LecturerDao {

	private static final String ADD_COURSE_TO_LECTURER_HQL_QUERY = "update Course set lecturer.id = :idLecturer where id= :idCourse";
	private static final String LECTURER_PARAMETER = "idLecturer";
	private static final String COURSE_PARAMETER = "idCourse";
	
	public Class<Lecturer> getGenericClass() {
		return Lecturer.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Lecturer_.id);
		sortMap.put(SortParam.NAME, Lecturer_.name);
		sortMap.put(SortParam.EMAIL, Lecturer_.email);
		sortMap.put(SortParam.PHONE_NUMBER, Lecturer_.number);
	}

	@Override
	public void addCourseToLecturer(Long idCourse, Long idLecturer) {
		Session session = getSession();
		Query query = session.createQuery(ADD_COURSE_TO_LECTURER_HQL_QUERY);
		query.setParameter(LECTURER_PARAMETER, idLecturer);
		query.setParameter(COURSE_PARAMETER, idCourse);
		query.executeUpdate();
	}

	@Override
	public List<Course> getCoursesByLecturerId(Long idLecturer) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Course> query = builder.createQuery(Course.class);
		Root<Course> root = query.from(Course.class);
		query.select(root).where(builder.equal(root.get(Course_.lecturer), idLecturer));
		TypedQuery<Course> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	protected void applyBasicFilters(LecturerSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Lecturer> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Lecturer_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Lecturer_.name), like(searchParam.getName())));
		}
		if (searchParam.getEmail() != null) {
			predicates.add(builder.like(root.get(Lecturer_.email), like(searchParam.getEmail())));
		}
		if (searchParam.getNumber() != null) {
			predicates.add(builder.like(root.get(Lecturer_.number), like(searchParam.getNumber())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

}
