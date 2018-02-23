package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.PairDao;
import com.senla.api.service.PairService;
import com.senla.entity.Pair;

@Repository
public class PairServiceImpl extends AbstractServiceImpl<Pair> implements PairService {

	@Autowired
	PairDao pairDao;

	@Override
	protected AbstractDao<Pair> getDao() {
		return pairDao;
	}

}
