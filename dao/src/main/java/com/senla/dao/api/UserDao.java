package com.senla.dao.api;

import com.senla.entity.User;

public interface UserDao extends AbstractDao<User> {

	User getUserByLogin(String login);

}
