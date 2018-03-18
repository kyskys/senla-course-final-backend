package com.senla.service.api;

import java.util.List;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

public interface StudentService extends AbstractService<Student>, Searchable<StudentSearchParams, Student> {

	List<Student> getStudentsByGroupId(Long idGroup);

	List<Student> getStudentsWithoutGroup();

}
