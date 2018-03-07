package com.senla.impl.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.UserDao;
import com.senla.api.service.UserService;
import com.senla.dao.util.AuthCodeEnum;
import com.senla.entity.User;

@Transactional
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	protected AbstractDao<User> getDao() {
		return userDao;
	}

	public AuthCodeEnum checkUser(String login, String password) {
		try {
			User user = userDao.getUserByLogin(login);
			return user.getPassword().equals(password) ? AuthCodeEnum.SUCCESS_AUTH : AuthCodeEnum.WRONG_PASSWORD;
		} catch (NoResultException e) {
			return AuthCodeEnum.LOGIN_NOT_EXIST;
		}
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

}
