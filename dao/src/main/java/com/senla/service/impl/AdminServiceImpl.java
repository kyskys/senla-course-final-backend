package com.senla.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.AdminDao;
import com.senla.entity.Admin;
import com.senla.service.api.AdminService;

@Service
public class AdminServiceImpl extends AbstractServiceImpl<Admin> implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	protected AbstractDao<Admin> getDao() {
		return adminDao;
	}

}
