package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.CourseService;
import com.senla.api.service.LecturerService;
import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course;
import com.senla.holder.support.CurrentUserSupport;
import com.senla.web.api.controller.CourseController;
import com.senla.web.dto.CourseDto;
import com.senla.web.dto.CourseGetDto;
import com.senla.web.dto.CourseLectionDto;
import com.senla.web.dto.CourseUpdateDto;
import com.senla.web.dto.CreateCourseDto;

@RestController
public class CourseControllerImpl implements CourseController, CurrentUserSupport {
	@Autowired
	CourseService courseService;
	@Autowired
	LecturerService lecturerService;

	@RequestMapping(value = "/api/course/{id}/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public CourseGetDto getCourse(@PathVariable("id") Long id) {
		return new CourseGetDto(courseService.get(id));
	}

	@RequestMapping(value = "/api/course/", method = RequestMethod.PUT)
	@Override
	public void createCourse(@RequestBody CreateCourseDto dto) {
		Course course = new Course();
		course.setLecturer(lecturerService.get(getCurrentUser().getId()));
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		courseService.create(course);
	}

	@RequestMapping(value = "/api/course/{id}", method = RequestMethod.DELETE)
	@Override
	public void deleteCourse(@PathVariable("id") Long id) {
		Course course = new Course();
		course.setId(id);
		courseService.delete(course);
	}

	@RequestMapping(value = "/api/course/{id}", method = RequestMethod.POST)
	@Override
	public void updateCourse(@RequestBody CourseUpdateDto dto, @PathVariable("id") Long id) {
		Course course = new Course();
		course.setId(id);
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		List<Long> lections = dto.getLections();
		if (lections != null) {
			for (Long idLection : lections) {
				courseService.addLectionToCourse(idLection, id);
			}
		}
		if (dto.getLecturer() != null) {
			course.setLecturer(lecturerService.get(dto.getLecturer()));
		}
		courseService.update(course);
	}

	@RequestMapping(value = "/api/course/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<CourseGetDto> getAllCourses() {
		return courseService.getAll().stream().map(CourseGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/course/search", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<CourseGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lecturer", required = false) String idLecturer, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		CourseSearchParams searchParam = new CourseSearchParams(id, name, idLecturer);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<CourseGetDto> result = courseService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(CourseGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "/api/course/{course}/add/lection/{lection}", method = RequestMethod.POST)
	@Override
	public void addLectionToCourse(@PathVariable("lection") Long idLection, @PathVariable("course") Long idCourse) {
		courseService.addLectionToCourse(idLection, idCourse);
	}

	@RequestMapping(value = "/api/course/{course}/remove/lection/{lection}", method = RequestMethod.POST)
	@Override
	public void removeLectionFromCourse(@PathVariable("lection") Long idLection) {
		courseService.removeLectionFromCourse(idLection);
	}

	@RequestMapping(value = "/api/course/{id}/lection/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<CourseLectionDto> getLectionsByCourseId(@PathVariable("id") Long idCourse,
			@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
		return courseService.getLectionsByCourseId(idCourse).stream().map(CourseLectionDto::new)
				.collect(Collectors.toList());
		//TODO dopisat vibor lekcii kyrsa
	}

	@RequestMapping(value = "/api/test", method = RequestMethod.GET, produces = "text/plain")
	@Override
	public String test() {
		return "{\"message\":\"testss\"}";
	}

	@RequestMapping(value = "/api/tests", method = RequestMethod.GET, produces = "text/plain")
	@Override
	public String tests() {
		return "{\"message\":\"testsssssss\"}";
	}

	@RequestMapping(value = "/api/course/count", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Long courseCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lecturer", required = false) String idLecturer) {
		CourseSearchParams searchParam = new CourseSearchParams(id, name, idLecturer);
		Long asd = courseService.count(searchParam);
		return asd;
	}
}
