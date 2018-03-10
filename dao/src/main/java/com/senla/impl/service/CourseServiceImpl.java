package com.senla.impl.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	@Override
	public void addlectionsToCourse(Long idCourse, List<Long> lections) {
		Course course = courseDao.get(idCourse);
		List<Long> courseLections = course.getLections().stream().map(lection -> lection.getId())
				.collect(Collectors.toList());
		for (Long idLection : lections) {
			if (courseLections.contains(idLection)) {
				courseLections.remove(idLection);
			} else {
				courseDao.addLectionToCourse(idLection, idCourse);
			}
		}
		for (Long idLection : courseLections) {
			courseDao.removeLectionFromCourse(idLection);
		}
	}

}
