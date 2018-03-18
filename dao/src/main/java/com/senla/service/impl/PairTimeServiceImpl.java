package com.senla.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.PairTimeDao;
import com.senla.entity.PairTime;
import com.senla.service.api.PairTimeService;

@Transactional
@Service
public class PairTimeServiceImpl extends AbstractServiceImpl<PairTime> implements PairTimeService {

	@Autowired
	PairTimeDao pairTimeDao;

	@Override
	protected AbstractDao<PairTime> getDao() {
		return pairTimeDao;
	}

}
