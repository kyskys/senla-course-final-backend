package com.senla.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.LecturerDao;
import com.senla.api.service.LecturerService;
import com.senla.dao.search.LecturerSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Course;
import com.senla.entity.Lecturer;

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

	@Transactional
	@Override
	public void addCourseToLecturer(Long idCourse, Long idLecturer) {
		lecturerDao.addCourseToLecturer(idCourse, idLecturer);
	}

	@Override
	public List<Course> getCoursesByLecturerId(Long idLecturer) {
		return lecturerDao.getCoursesByLecturerId(idLecturer);
	}	

}
