package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.CourseGetDto;
import com.senla.web.dto.CourseLectionDto;
import com.senla.web.dto.CourseUpdateDto;
import com.senla.web.dto.CreateCourseDto;

public interface CourseController {
	CourseGetDto getCourse(Long id);

	CourseGetDto createCourse(CreateCourseDto dto);

	void deleteCourse(Long id);

	void updateCourse(CourseUpdateDto dto, Long id);

	Long courseCount(Long id, String name, String lecturer);

	List<CourseGetDto> getAllCourses();

	List<CourseGetDto> search(String sortBy, Long id, String name, String lecturer, Integer limit, Integer offset,
			boolean asc);

	void addLectionToCourse(Long idLection, Long idCourse);

	void removeLectionFromCourse(Long idLection);

	List<CourseLectionDto> getLectionsByCourseId(Long idCourse, Integer limit, Integer offset);	

}
