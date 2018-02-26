package com.senla.api.service;

import com.senla.entity.Course;

public interface CourseService extends AbstractService<Course> {
	boolean addLectionToCourse(Long idLection, Long idCourse);

	boolean removeLectionFromCourse(Long idLection, Long idCourse);

}
