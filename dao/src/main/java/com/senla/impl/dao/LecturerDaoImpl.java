package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.LecturerDao;
import com.senla.entity.Lecturer;

@Repository
public class LecturerDaoImpl extends AbstractDaoImpl<Lecturer> implements LecturerDao {

	public Class<Lecturer> getGenericClass() {
		return Lecturer.class;
	}

}
