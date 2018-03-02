package com.senla.api.dao;

import java.util.List;

import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lecturer;

public interface LecturerDao extends AbstractDao<Lecturer>, Searchable<LecturerSearchParams, Lecturer> {

	void addCourseToLecturer(Long idCourse, Long idLecturer);

	List<Course> getCoursesByLecturerId(Long idLecturer);

}
