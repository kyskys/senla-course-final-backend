package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.PairDao;
import com.senla.entity.Pair;

@Repository
public class PairDaoImpl extends AbstractDaoImpl<Pair> implements PairDao {

	public Class<Pair> getGenericClass() {
		return Pair.class;
	}

}
