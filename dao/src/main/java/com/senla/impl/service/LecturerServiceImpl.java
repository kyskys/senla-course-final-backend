package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.LecturerDao;
import com.senla.api.service.LecturerService;
import com.senla.entity.Lecturer;

@Service
public class LecturerServiceImpl extends AbstractServiceImpl<Lecturer> implements LecturerService {

	@Autowired
	LecturerDao lecturerDao;

	@Override
	protected AbstractDao<Lecturer> getDao() {
		return lecturerDao;
	}

}
