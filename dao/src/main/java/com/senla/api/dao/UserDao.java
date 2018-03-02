package com.senla.api.dao;

import com.senla.entity.User;

public interface UserDao extends AbstractDao<User> {

	User getUserByLogin(String login);

}
