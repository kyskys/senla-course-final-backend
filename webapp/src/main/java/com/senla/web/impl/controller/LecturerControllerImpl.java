package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lecturer;
import com.senla.entity.util.DictionaryItem;
import com.senla.service.api.LecturerService;
import com.senla.web.dto.lecturer.LecturerGetDto;
import com.senla.web.dto.lecturer.LecturerUpdateDto;

@RestController
@RequestMapping("/api/lecturer/")
public class LecturerControllerImpl {
	@Autowired
	LecturerService lecturerService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public LecturerGetDto getLecturer(@PathVariable("id") Long id) {
		return new LecturerGetDto(lecturerService.get(id));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteLecturer(@PathVariable("id") Long id) {
		Lecturer lecturer = new Lecturer();
		lecturer.setId(id);
		lecturerService.delete(lecturer);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<LecturerGetDto> getAllLecturers() {
		return lecturerService.getAll().stream().map(LecturerGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<LecturerGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "number", required = false) Integer number, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		LecturerSearchParams searchParam = new LecturerSearchParams(id, email, name, number);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<LecturerGetDto> result = lecturerService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(LecturerGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long lecturerCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "number", required = false) Integer number) {
		LecturerSearchParams searchParam = new LecturerSearchParams(id, name, email, number);
		return lecturerService.count(searchParam);
	}

	/*@RequestMapping(value = "{lecturer}/add/course/{course}", method = RequestMethod.POST)
	public void addCourseToLecturer(@PathVariable("course") Long idCourse, @PathVariable("lecturer") Long idLecturer) {
		lecturerService.addCourseToLecturer(idCourse, idLecturer);
	}*/
	
	@RequestMapping(value="dictionary",method=RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return lecturerService.getDictionary();
	}
	

}
