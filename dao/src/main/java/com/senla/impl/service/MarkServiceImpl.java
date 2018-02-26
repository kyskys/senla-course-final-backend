package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.MarkDao;
import com.senla.api.service.MarkService;
import com.senla.entity.Mark;

@Service
public class MarkServiceImpl extends AbstractServiceImpl<Mark> implements MarkService {

	@Autowired
	MarkDao markDao;

	@Override
	protected AbstractDao<Mark> getDao() {
		return markDao;
	}

}