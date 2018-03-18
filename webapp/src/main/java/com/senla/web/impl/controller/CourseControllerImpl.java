package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Course;
import com.senla.entity.util.DictionaryItem;
import com.senla.holder.support.CurrentUserSupport;
import com.senla.service.api.CourseService;
import com.senla.service.api.LecturerService;
import com.senla.web.dto.course.CourseGetDto;
import com.senla.web.dto.course.CourseUpdateDto;
import com.senla.web.dto.course.CourseCreateDto;

@RestController
@RequestMapping(value = "/api/course/")
public class CourseControllerImpl implements CurrentUserSupport {
	@Autowired
	CourseService courseService;
	@Autowired
	LecturerService lecturerService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public CourseGetDto getCourse(@PathVariable("id") Long id) {
		return new CourseGetDto(courseService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public CourseGetDto createCourse(@Valid @RequestBody CourseCreateDto dto) {
		Course course = new Course();
		course.setLecturer(lecturerService.get(getCurrentUser().getId()));
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		return new CourseGetDto(courseService.create(course));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") Long id) {
		Course course = new Course();
		course.setId(id);
		courseService.delete(course);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateCourse(@Valid @RequestBody CourseUpdateDto dto, @PathVariable("id") Long id) {
		Course course = courseService.get(id);
		String name = dto.getName();
		if (!StringUtils.isEmpty(name)) {
			course.setName(name);
		}
		String description = dto.getDescription();
		if (!StringUtils.isEmpty(description)) {
			course.setDescription(description);
		}
		Long lecturer = dto.getLecturer();
		if (lecturer != null && lecturer != 0) {
			course.setLecturer(lecturerService.get(lecturer));
		}
		courseService.update(course);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CourseGetDto> getAllCourses() {
		return courseService.getAll().stream().map(CourseGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public List<CourseGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lecturer", required = false) String lecturer, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		CourseSearchParams searchParam = new CourseSearchParams(id, name, lecturer);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<CourseGetDto> result = courseService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(CourseGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "{course}/add/lection/{lection}", method = RequestMethod.POST)
	public void addLectionToCourse(@PathVariable("lection") Long idLection, @PathVariable("course") Long idCourse) {
		courseService.addLectionToCourse(idLection, idCourse);
	}

	@RequestMapping(value = "{course}/remove/lection/{lection}", method = RequestMethod.POST)
	public void removeLectionFromCourse(@PathVariable("lection") Long idLection) {
		courseService.removeLectionFromCourse(idLection);
	}

	@RequestMapping(value = "count", method = RequestMethod.GET)
	public Long courseCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lecturer", required = false) String lecturer) {
		CourseSearchParams searchParam = new CourseSearchParams(id, name, lecturer);
		return courseService.count(searchParam);
	}

	@RequestMapping(value = "{id}/add/lection", method = RequestMethod.POST)
	public void addLectionsToCourse(@PathVariable("id") Long idCourse, @RequestBody List<Long> lections) {
		courseService.addlectionsToCourse(idCourse, lections);
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return courseService.getDictionary();
	}
}
