package com.senla.dao.api;

import java.util.List;

import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lection;

public interface CourseDao extends AbstractDao<Course>, Searchable<CourseSearchParams, Course> {

	void addLectionToCourse(Long idLection, Long idCourse);

	void removeLectionFromCourse(Long idLection);

	List<Lection> getLectionsByCourseId(Long idCourse);

}
