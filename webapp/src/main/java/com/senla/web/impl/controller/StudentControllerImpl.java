package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.GroupService;
import com.senla.api.service.StudentService;
import com.senla.dao.search.StudentSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Student;
import com.senla.web.api.controller.StudentController;
import com.senla.web.dto.StudentGetDto;
import com.senla.web.dto.StudentUpdateDto;

@RestController
public class StudentControllerImpl implements StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/api/student/{id}/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public StudentGetDto getStudent(@PathVariable("id") Long id) {
		return new StudentGetDto(studentService.get(id));
	}

	@RequestMapping(value = "/api/student/{id}", method = RequestMethod.DELETE)
	@Override
	public void deleteStudent(@PathVariable("id") Long id) {
		Student student = new Student();
		student.setId(id);
		studentService.delete(student);
	}

	@RequestMapping(value = "/api/student/{id}", method = RequestMethod.POST)
	@Override
	public void updateStudent(StudentUpdateDto dto, @PathVariable("id") Long id) {
		Student student = new Student();
		student.setId(id);
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setPassword(dto.getPassword());
		student.setNumber(dto.getNumber());
		Long idGroup = dto.getGroup();
		if (idGroup != null) {
			groupService.addStudentToGroup(id, idGroup);
		}
		studentService.update(student);
	}

	@RequestMapping(value = "/api/student/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<StudentGetDto> getAllStudents() {
		return studentService.getAll().stream().map(StudentGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/student/search", method = RequestMethod.GET, produces = "application/json")
	@Override
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

	@RequestMapping(value = "/api/student/count", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Long studentCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "group", required = false) String group) {
		StudentSearchParams searchParam = new StudentSearchParams(id, name, email, number, group);
		return studentService.count(searchParam);
	}

}
