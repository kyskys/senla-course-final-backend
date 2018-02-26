package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import com.senla.api.dao.LectionDao;
import com.senla.entity.Lection;

@Repository
public class LectionDaoImpl extends AbstractDaoImpl<Lection> implements LectionDao {

	public Class<Lection> getGenericClass() {
		return Lection.class;
	}

}
