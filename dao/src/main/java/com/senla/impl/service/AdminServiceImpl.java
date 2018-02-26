package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.AdminDao;
import com.senla.api.service.AdminService;
import com.senla.entity.Admin;

@Service
public class AdminServiceImpl extends AbstractServiceImpl<Admin> implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	protected AbstractDao<Admin> getDao() {
		return adminDao;
	}

}
