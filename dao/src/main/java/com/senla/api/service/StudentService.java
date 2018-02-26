package com.senla.api.service;

import com.senla.entity.Student;

public interface StudentService extends AbstractService<Student> {
	boolean addGroupToStudent(Long idGroup, Long idStudent);

	boolean removeGroupFromStudent(Long idGroup, Long idStudent);

}
