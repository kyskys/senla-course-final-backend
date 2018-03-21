package com.senla.service.api;

import com.senla.dao.util.CodeEnum;
import com.senla.entity.User;

public interface UserService extends AbstractService<User> {
	User getUserByLogin(String login);

	CodeEnum checkUser(String login, String password);
	
	boolean isUserExist(String login);
}
