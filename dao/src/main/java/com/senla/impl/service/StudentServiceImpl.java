package com.senla.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.StudentDao;
import com.senla.api.service.StudentService;
import com.senla.dao.search.Searchable;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

@Transactional
@Service
public class StudentServiceImpl extends SearchableServiceImpl<StudentSearchParams, Student> implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	protected AbstractDao<Student> getDao() {
		return studentDao;
	}

	@Override
	protected Searchable<StudentSearchParams, Student> getSearchableDao() {
		return studentDao;
	}

	@Override
	public List<Student> getStudentsByGroupId(Long idGroup) {
		return studentDao.getStudentsByGroupId(idGroup);
	}

	@Override
	public List<Student> getStudentsWithoutGroup() {
		return studentDao.getStudentsWithoutGroup();
	}

}
