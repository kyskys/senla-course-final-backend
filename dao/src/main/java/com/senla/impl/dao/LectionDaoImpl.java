package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.LectionDao;
import com.senla.entity.Lection;

@Repository
public class LectionDaoImpl extends AbstractDaoImpl<Lection> implements LectionDao {

	public Class<Lection> getGenericClass() {
		return Lection.class;
	}

}
