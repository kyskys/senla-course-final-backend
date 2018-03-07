package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.PairDao;
import com.senla.api.service.PairService;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Pair;

@Transactional
@Service
public class PairServiceImpl extends SearchableServiceImpl<PairSearchParams, Pair> implements PairService {

	@Autowired
	PairDao pairDao;

	@Override
	protected AbstractDao<Pair> getDao() {
		return pairDao;
	}

	@Override
	protected Searchable<PairSearchParams, Pair> getSearchableDao() {
		return pairDao;
	}

}
