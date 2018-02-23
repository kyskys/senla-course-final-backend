package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.StudentDao;
import com.senla.api.service.StudentService;
import com.senla.entity.Student;

@Repository
public class StudentServiceImpl extends AbstractServiceImpl<Student> implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	protected AbstractDao<Student> getDao() {
		return studentDao;
	}

}
