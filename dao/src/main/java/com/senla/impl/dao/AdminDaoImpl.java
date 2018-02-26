package com.senla.impl.dao;

import org.springframework.stereotype.Repository;

import com.senla.api.dao.AdminDao;
import com.senla.entity.Admin;

@Repository
public class AdminDaoImpl extends AbstractDaoImpl<Admin> implements AdminDao {

	@Override
	public Class<Admin> getGenericClass() {
		return Admin.class;
	}

}
