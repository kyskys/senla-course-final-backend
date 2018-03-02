package com.senla.api.dao;

import com.senla.dao.search.Searchable;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

public interface StudentDao extends AbstractDao<Student>, Searchable<StudentSearchParams, Student> {

}
