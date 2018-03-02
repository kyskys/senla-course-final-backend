package com.senla.impl.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.api.dao.UserDao;
import com.senla.entity.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	@Override
	public Class<User> getGenericClass() {
		return User.class;
	}

	@Override
	public User getUserByLogin(String login) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("login"), login));
		TypedQuery<User> result = session.createQuery(query);
		User user = result.getSingleResult();
		return user;
	}

	
}
