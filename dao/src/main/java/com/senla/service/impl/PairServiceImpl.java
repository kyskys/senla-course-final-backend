package com.senla.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.AbstractDao;
import com.senla.dao.api.GroupDao;
import com.senla.dao.api.PairDao;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;
import com.senla.service.api.PairService;

@Transactional
@Service
public class PairServiceImpl extends SearchableServiceImpl<PairSearchParams, Pair> implements PairService {

	@Autowired
	PairDao pairDao;
	@Autowired
	GroupDao groupDao;

	@Override
	protected AbstractDao<Pair> getDao() {
		return pairDao;
	}

	@Override
	protected Searchable<PairSearchParams, Pair> getSearchableDao() {
		return pairDao;
	}

	@Override
	public List<Pair> getPairsByGroupId(Long idGroup) {
		return pairDao.getPairsByGroupId(idGroup);
	}

	@Override
	public List<Pair> getPairsByWeek(LocalDateTime startOfWeek, Long idGroup) {
		return pairDao.getPairsByWeek(startOfWeek, idGroup);
	}

	@Override
	public void addGroupsToPair(Long idPair, List<Long> groups) {
		Pair pair = pairDao.get(idPair);
		List<Long> pairGroups = pair.getGroups().stream().map(group -> group.getId())
				.collect(Collectors.toList());
		for (Long idGroup : groups) {
			if (pairGroups.contains(idGroup)) {
				pairGroups.remove(idGroup);
			} else {
				Group group = groupDao.get(idGroup);
				group.getPairs().add(pair);
				groupDao.update(group);
			}
		}
		for (Long idGroup : pairGroups) {
			Group group = groupDao.get(idGroup);
			group.getPairs().remove(pair);
			groupDao.update(group);
		}
	}

}
