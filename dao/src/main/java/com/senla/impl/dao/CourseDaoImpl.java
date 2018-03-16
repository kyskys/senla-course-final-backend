package com.senla.impl.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

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
import com.senla.entity.Course_;
import com.senla.entity.Lection;
import com.senla.entity.Lection_;
import com.senla.entity.Lecturer_;

@Repository
public class CourseDaoImpl extends SearchableDaoImpl<CourseSearchParams, Course> implements CourseDao {

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Course_.id);
		sortMap.put(SortParam.NAME, Course_.name);
		sortMap.put(SortParam.LECTURER_ID, Course_.lecturer);
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
		query.select(root).where(builder.equal(root.join(Lection_.course).get(Course_.id), idCourse));
		TypedQuery<Lection> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	protected void applyBasicFilters(CourseSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder, Root<Course> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Course_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Course_.name), like(searchParam.getName())));
		}
		if (searchParam.getLecturer() != null) {
			predicates.add(builder.like(root.join(Course_.lecturer).get(Lecturer_.name), like(searchParam.getLecturer())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

}
