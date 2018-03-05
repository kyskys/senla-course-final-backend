package com.senla.api.service;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

public interface StudentService extends AbstractService<Student>, Searchable<StudentSearchParams, Student> {

}
