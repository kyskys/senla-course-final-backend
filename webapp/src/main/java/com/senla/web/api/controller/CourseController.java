package com.senla.web.api.controller;

import java.util.List;

import com.senla.dao.search.CourseSearchParams;
import com.senla.web.dto.CourseDto;
import com.senla.web.dto.CourseGetDto;
import com.senla.web.dto.CourseLectionDto;
import com.senla.web.dto.CourseUpdateDto;
import com.senla.web.dto.CreateCourseDto;

public interface CourseController {
	CourseGetDto getCourse(Long id);

	void createCourse(CreateCourseDto dto);

	void deleteCourse(Long id);

	void updateCourse(CourseUpdateDto dto, Long id);

	Long courseCount(Long id, String name, String idLecturer);

	List<CourseGetDto> getAllCourses();

	List<CourseGetDto> search(String sortBy, Long id, String name, String idLecturer, Integer limit, Integer offset,
			boolean asc);

	void addLectionToCourse(Long idLection, Long idCourse);

	void removeLectionFromCourse(Long idLection);

	String test();

	String tests();

	List<CourseLectionDto> getLectionsByCourseId(Long idCourse, Integer limit, Integer offset);

	

	

}
