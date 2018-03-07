package com.senla.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.LectionDao;
import com.senla.api.service.LectionService;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Lection;

@Transactional
@Service
public class LectionServiceImpl extends SearchableServiceImpl<LectionSearchParams, Lection> implements LectionService {

	@Autowired
	LectionDao lectionDao;

	@Override
	protected AbstractDao<Lection> getDao() {
		return lectionDao;
	}

	@Override
	protected Searchable<LectionSearchParams, Lection> getSearchableDao() {
		return lectionDao;
	}

	@Override
	public void addPairToLection(Long idPair, Long idLection) {
		lectionDao.addPairToLection(idPair, idLection);
	}

	@Override
	public void removePairFromLection(Long idLection) {
		lectionDao.removePairFromLection(idLection);
	}

}
