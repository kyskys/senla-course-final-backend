package com.senla.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.MarkDao;
import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Mark;
import com.senla.service.api.MarkService;

@Transactional
@Service
public class MarkServiceImpl extends SearchableServiceImpl<MarkSearchParams, Mark> implements MarkService {

	@Autowired
	MarkDao markDao;

	@Override
	protected AbstractDao<Mark> getDao() {
		return markDao;
	}

	@Override
	protected Searchable<MarkSearchParams, Mark> getSearchableDao() {
		return markDao;
	}

	@Override
	public List<Mark> getMarksByStudentId(Long idStudent) {
		return markDao.getMarksByStudentId(idStudent);
	}

	@Override
	public List<Mark> getMarksByPairId(Long idPair) {
		return markDao.getMarksByPairId(idPair);
	}

}
