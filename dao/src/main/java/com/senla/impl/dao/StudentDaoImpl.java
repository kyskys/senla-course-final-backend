package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import com.senla.api.dao.StudentDao;
import com.senla.entity.Student;

@Repository
public class StudentDaoImpl extends AbstractDaoImpl<Student> implements StudentDao {

	public Class<Student> getGenericClass() {
		return Student.class;
	}

}
