package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.MarkDao;
import com.senla.entity.Mark;

@Repository
public class MarkDaoImpl extends AbstractDaoImpl<Mark> implements MarkDao {

	public Class<Mark> getGenericClass() {
		return Mark.class;
	}

}
