package com.senla.impl.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.api.dao.PairTimeDao;
import com.senla.dao.util.DateFormatterUtil;
import com.senla.entity.PairTime;
import com.senla.entity.util.DictionaryItem;

@Repository
public class PairTimeDaoImpl extends AbstractDaoImpl<PairTime> implements PairTimeDao {

	@Override
	public Class<PairTime> getGenericClass() {
		return PairTime.class;
	}

	@Override
	public List<DictionaryItem> getDictionary() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = builder.createTupleQuery();
		Root<PairTime> root = query.from(PairTime.class);
		query.multiselect(root.get("id"), root.get("startTime"), root.get("endTime"));
		TypedQuery<Tuple> result = session.createQuery(query);
		List<Tuple> tupleResult = result.getResultList();
		List<DictionaryItem> dictionary = new ArrayList<DictionaryItem>();
		for (Tuple tuple : tupleResult) {
			Long id = (Long) tuple.get(0);
			LocalTime startTime = (LocalTime) tuple.get(1);
			LocalTime endTime = (LocalTime) tuple.get(2);
			String name = DateFormatterUtil.getTimeAsString(startTime) + " - "
					+ DateFormatterUtil.getTimeAsString(endTime);
			DictionaryItem entity = new DictionaryItem(id, name);
			dictionary.add(entity);
		}
		return dictionary;
	}
}
