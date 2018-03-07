package com.senla.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.CourseDao;
import com.senla.api.service.CourseService;
import com.senla.dao.search.CourseSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lection;

@Transactional
@Service
public class CourseServiceImpl extends SearchableServiceImpl<CourseSearchParams, Course> implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Override
	protected AbstractDao<Course> getDao() {
		return courseDao;
	}

	@Override
	protected Searchable<CourseSearchParams, Course> getSearchableDao() {
		return courseDao;
	}

	@Override
	public void addLectionToCourse(Long idLection, Long idCourse) {
		courseDao.addLectionToCourse(idLection, idCourse);
	}

	@Override
	public void removeLectionFromCourse(Long idLection) {
		courseDao.removeLectionFromCourse(idLection);
	}

	@Override
	public List<Lection> getLectionsByCourseId(Long idCourse) {
		return courseDao.getLectionsByCourseId(idCourse);
	}

}
