package com.senla.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.GroupDao;
import com.senla.api.dao.PairDao;
import com.senla.api.service.GroupService;
import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;

@Transactional
@Service
public class GroupServiceImpl extends SearchableServiceImpl<GroupSearchParams, Group> implements GroupService {

	@Autowired
	GroupDao groupDao;
	@Autowired
	PairDao pairDao;

	@Override
	protected AbstractDao<Group> getDao() {
		return groupDao;
	}

	@Override
	protected Searchable<GroupSearchParams, Group> getSearchableDao() {
		return groupDao;
	}

	@Override
	public void addPairToGroup(Long idPair, Long idGroup) {
		Group group = groupDao.get(idGroup);
		Pair pair = pairDao.get(idPair);
		group.getPairs().add(pair);
		groupDao.update(group);
	}

	@Override
	public void removePairFromGroup(Long idPair, Long idGroup) {
		Group group = groupDao.get(idGroup);
		Pair pair = pairDao.get(idPair);
		group.getPairs().remove(pair);
		groupDao.update(group);
	}

	@Override
	public void addStudentToGroup(Long idStudent, Long idGroup) {
		groupDao.addStudentToGroup(idStudent, idGroup);
	}

	@Override
	public void removeStudentFromGroup(Long idStudent) {
		groupDao.removeStudentFromGroup(idStudent);
	}

	@Override
	public List<Pair> getPairsByGroupId(Long idGroup) {
		return groupDao.getPairsByGroupId(idGroup);
	}

	@Override
	public List<Student> getStudentsByGroupId(Long idGroup) {
		return groupDao.getStudentsByGroupId(idGroup);
	}

}
