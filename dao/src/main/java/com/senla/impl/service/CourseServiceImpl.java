package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.CourseDao;
import com.senla.api.service.CourseService;
import com.senla.entity.Course;

@Repository
public class CourseServiceImpl extends AbstractServiceImpl<Course> implements CourseService {

	@Autowired
	CourseDao courseDao;
	@Override
	protected AbstractDao<Course> getDao() {
		return courseDao;
	}

}
