package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.search.SortParam;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;
import com.senla.entity.util.DictionaryItem;
import com.senla.service.api.GroupService;
import com.senla.service.api.StudentService;
import com.senla.web.dto.student.StudentGetDto;
import com.senla.web.dto.student.StudentUpdateDto;

@RestController
@RequestMapping("/api/student/")
public class StudentControllerImpl {
	@Autowired
	StudentService studentService;
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public StudentGetDto getStudent(@PathVariable("id") Long id) {
		return new StudentGetDto(studentService.get(id));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") Long id) {
		Student student = new Student();
		student.setId(id);
		studentService.delete(student);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<StudentGetDto> getAllStudents() {
		return studentService.getAll().stream().map(StudentGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<StudentGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "group", required = false) String group, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		StudentSearchParams searchParam = new StudentSearchParams(id, name, email, number, group);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<StudentGetDto> result = studentService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(StudentGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long studentCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "group", required = false) String group) {
		StudentSearchParams searchParam = new StudentSearchParams(id, name, email, number, group);
		return studentService.count(searchParam);
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET)
	public List<StudentGetDto> getStudentsByGroupId(@PathVariable("group") Long idGroup) {
		List<StudentGetDto> result = studentService.getStudentsByGroupId(idGroup).stream().map(StudentGetDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "group/", method = RequestMethod.GET)
	public List<StudentGetDto> getStudentsWithoutGroup() {
		List<StudentGetDto> result = studentService.getStudentsWithoutGroup().stream().map(StudentGetDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return studentService.getDictionary();
	}
}
