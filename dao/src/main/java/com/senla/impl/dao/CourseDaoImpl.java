package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.CourseDao;
import com.senla.entity.Course;

@Repository
public class CourseDaoImpl extends AbstractDaoImpl<Course> implements CourseDao {

	public Class<Course> getGenericClass() {
		return Course.class;
	}

}
