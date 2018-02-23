package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.LectionDao;
import com.senla.api.service.LectionService;
import com.senla.entity.Lection;

@Repository
public class LectionServiceImpl extends AbstractServiceImpl<Lection> implements LectionService {

	@Autowired
	LectionDao lectionDao;

	@Override
	protected AbstractDao<Lection> getDao() {
		return lectionDao;
	}

}
