package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.GroupDao;
import com.senla.api.service.GroupService;
import com.senla.entity.Group;

@Service
public class GroupServiceImpl extends AbstractServiceImpl<Group> implements GroupService {

	@Autowired
	GroupDao groupDao;

	@Override
	protected AbstractDao<Group> getDao() {
		return groupDao;
	}

}
