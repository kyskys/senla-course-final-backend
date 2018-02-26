package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.CourseDao;
import com.senla.api.service.CourseService;
import com.senla.dao.util.CourseSearchParam;
import com.senla.entity.Course;

@Service
public class CourseServiceImpl extends SearchableServiceImpl<Course, CourseSearchParam> implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Override
	protected AbstractDao<Course> getDao() {
		return courseDao;
	}

	@Override
	public boolean addLectionToCourse(Long idLection, Long idCourse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLectionFromCourse(Long idLection, Long idCourse) {
		// TODO Auto-generated method stub
		return false;
	}

}
