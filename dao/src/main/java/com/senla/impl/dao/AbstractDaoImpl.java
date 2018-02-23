package com.senla.impl.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.entity.AbstractEntity;

@Repository
public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {
	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		try {
			return factory.getCurrentSession();
		} catch (HibernateException e) {
			return factory.openSession();
		}
	}

	public boolean create(T entity) {
		getSession().save(entity);
		return true;
	}

	public boolean delete(T entity) {
		getSession().delete(entity);
		return true;
	}

	public boolean update(T entity) {
		getSession().update(entity);
		return true;
	}

	public T get(Long id) {
		getSession().get(getGenericClass(), id);
		return null;
	}

	public List<T> getAll() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		TypedQuery<T> result = session.createQuery(query);
		return result.getResultList();
	}

}
