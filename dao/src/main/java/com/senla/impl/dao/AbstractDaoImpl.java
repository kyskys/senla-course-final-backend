package com.senla.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.senla.api.dao.AbstractDao;
import com.senla.entity.AbstractEntity;
import com.senla.entity.util.DictionaryItem;

public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {
	@Autowired
	private SessionFactory factory;

	protected Session getSession() {
		try {
			return factory.getCurrentSession();
		} catch (HibernateException e) {
			return factory.openSession();
		}
	}

	@Override
	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T get(Long id) {
		return getSession().get(getGenericClass(), id);
	}

	@Override
	public List<T> getAll() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		TypedQuery<T> result = session.createQuery(query);
		return result.getResultList();
	}
	
	@Override
	public Long count() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<T> root = query.from(getGenericClass());
		query.select(builder.count(root));
		TypedQuery<Long> result = session.createQuery(query);
		return result.getSingleResult();
	}

	@Override
	public List<DictionaryItem> getDictionary() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = builder.createTupleQuery();
		Root<T> root = query.from(getGenericClass());
		query.multiselect(root.get("id"),root.get("name"));
		TypedQuery<Tuple> result = session.createQuery(query);
		List<Tuple> tupleResult=result.getResultList();
		List<DictionaryItem> dictionary = new ArrayList<DictionaryItem>();
		for(Tuple tuple: tupleResult) {
			Long id = (Long) tuple.get(0);
			String name = (String) tuple.get(1);
			DictionaryItem entity = new DictionaryItem(id,name);
			dictionary.add(entity);
		}
		return dictionary;
	}

}
