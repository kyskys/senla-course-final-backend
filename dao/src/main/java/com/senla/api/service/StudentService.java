package com.senla.api.service;

import com.senla.entity.Student;

public interface StudentService extends AbstractService<Student> {
	void addGroupToStudent(Long idGroup, Long idStudent);

	void removeGroupFromStudent(Long idGroup, Long idStudent);

}
