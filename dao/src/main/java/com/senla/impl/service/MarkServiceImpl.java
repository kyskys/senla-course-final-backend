package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.MarkDao;
import com.senla.api.service.MarkService;
import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Mark;

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
	public void cloneMarkToPair(Long idPair, Long idMark) {
		markDao.cloneMarkToPair(idPair, idMark);
	}

	@Override
	public void cloneMarkToStudent(Long idStudent, Long idMark) {
		markDao.cloneMarkToStudent(idStudent, idMark);
	}

}
