package com.senla.api.service;

import com.senla.dao.util.AuthCodeEnum;
import com.senla.entity.User;

public interface UserService extends AbstractService<User> {
	User getUserByLogin(String login);

	AuthCodeEnum checkUser(String login, String password);
}
