package com.senla.service.impl;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.UserDao;
import com.senla.dao.util.CodeEnum;
import com.senla.entity.User;
import com.senla.service.api.UserService;

@Transactional
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	protected AbstractDao<User> getDao() {
		return userDao;
	}

	public CodeEnum checkUser(String login, String password) {
		try {
			User user = userDao.getUserByLogin(login);
			return user.getPassword().equals(password) ? CodeEnum.SUCCESS_AUTH : CodeEnum.WRONG_PASSWORD;
		} catch (NoResultException e) {
			return CodeEnum.LOGIN_NOT_EXIST;
		}
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

}
