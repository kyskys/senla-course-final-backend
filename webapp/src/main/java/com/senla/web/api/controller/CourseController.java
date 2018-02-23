package com.senla.web.api.controller;

import java.util.List;

import com.senla.entity.Course;
import com.senla.web.dto.CourseDto;

public interface CourseController {
	Course getCourse(Long id);

	void createCourse(CourseDto dto);

	void deleteCourse(CourseDto dto);

	void updateCourse(CourseDto dto);

	List<CourseDto> getAllCourses();
}
