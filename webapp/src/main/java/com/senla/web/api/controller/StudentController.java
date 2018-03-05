package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.StudentGetDto;
import com.senla.web.dto.StudentUpdateDto;

public interface StudentController {
	StudentGetDto getStudent(Long id);

	void deleteStudent(Long id);

	void updateStudent(StudentUpdateDto dto, Long id);

	List<StudentGetDto> getAllStudents();

	List<StudentGetDto> search(String sortBy, Long id, String name, String email, Integer number, String group,
			Integer limit, Integer offset, boolean asc);

	Long studentCount(Long id, String name, String email, Integer number, String group);
}
