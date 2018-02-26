package com.senla.impl.dao;

import org.springframework.stereotype.Repository;

import com.senla.api.dao.PairTimeDao;
import com.senla.entity.PairTime;

@Repository
public class PairTimeDaoImpl extends AbstractDaoImpl<PairTime> implements PairTimeDao {

	@Override
	public Class<PairTime> getGenericClass() {
		return PairTime.class;
	}

}
