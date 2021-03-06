package com.senla.dao.api;

import java.util.List;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

public interface StudentDao extends AbstractDao<Student>, Searchable<StudentSearchParams, Student> {

	List<Student> getStudentsWithoutGroup();

	List<Student> getStudentsByGroupId(Long idGroup);

}
