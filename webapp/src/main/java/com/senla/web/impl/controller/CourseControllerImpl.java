package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.CourseService;
import com.senla.entity.Course;
import com.senla.web.api.controller.CourseController;
import com.senla.web.dto.CourseDto;

@RestController
public class CourseControllerImpl implements CourseController {
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/api/course", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Course getCourse(@RequestParam(value = "id") Long id) {
		return courseService.get(id);
	}

	@RequestMapping(value = "/api/course", method = RequestMethod.PUT)
	@Override
	public void createCourse(@RequestBody CourseDto dto) {
		Course course = new Course();
		course.setId(dto.getId());
		courseService.create(course);
		course.setDescription(dto.getDescription());
		for (Long idLection : dto.getLections()) {
			// courseService.
		}
		// course.setLections(courseDto.ge);
	}

	@Override
	public void deleteCourse(CourseDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCourse(CourseDto dto) {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/api/courses", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<CourseDto> getAllCourses() {
		return courseService.getAll().stream().map(CourseDto::new).collect(Collectors.toList());
	}

}
