package com.senla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.LecturerDao;
import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lecturer;
import com.senla.service.api.LecturerService;

@Transactional
@Service
public class LecturerServiceImpl extends SearchableServiceImpl<LecturerSearchParams, Lecturer> implements LecturerService {

	@Autowired
	LecturerDao lecturerDao;
	
	@Override
	protected AbstractDao<Lecturer> getDao() {
		return lecturerDao;
	}
	
	@Override
	protected Searchable<LecturerSearchParams, Lecturer> getSearchableDao() {
		return lecturerDao;
	}

	@Override
	public void addCourseToLecturer(Long idCourse, Long idLecturer) {
		lecturerDao.addCourseToLecturer(idCourse, idLecturer);
	}

	@Override
	public List<Course> getCoursesByLecturerId(Long idLecturer) {
		return lecturerDao.getCoursesByLecturerId(idLecturer);
	}

}
