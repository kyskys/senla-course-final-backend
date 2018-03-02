package com.senla.api.service;

import java.util.List;

import com.senla.entity.Course;
import com.senla.entity.Lecturer;

public interface LecturerService extends AbstractService<Lecturer> {
	void addCourseToLecturer(Long idCourse, Long idLecturer);
	
	List<Course> getCoursesByLecturerId(Long idLecturer);
}
