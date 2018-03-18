package com.senla.dao.impl;

import org.springframework.stereotype.Repository;

import com.senla.dao.api.AdminDao;
import com.senla.entity.Admin;

@Repository
public class AdminDaoImpl extends AbstractDaoImpl<Admin> implements AdminDao {

	@Override
	public Class<Admin> getGenericClass() {
		return Admin.class;
	}

}
