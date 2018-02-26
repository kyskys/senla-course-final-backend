package com.senla.api.service;

import com.senla.entity.Lecturer;

public interface LecturerService extends AbstractService<Lecturer> {
	boolean addCourseToLecturer(Long idCourse, Long idLecturer);

	boolean removeCourseFromLecturer(Long idCourse, Long idLecturer);

}
