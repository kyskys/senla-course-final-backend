package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.PairTimeDao;
import com.senla.api.service.PairTimeService;
import com.senla.entity.PairTime;

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
