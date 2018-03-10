package com.senla.api.service;

import java.util.List;

import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lection;

public interface CourseService extends AbstractService<Course>, Searchable<CourseSearchParams, Course> {
	void addLectionToCourse(Long idLection, Long idCourse);

	void removeLectionFromCourse(Long idLection);

	List<Lection> getLectionsByCourseId(Long idCourse);

	void addlectionsToCourse(Long idCourse, List<Long> lections);

}
