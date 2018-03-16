package com.senla.impl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.api.dao.AbstractDao;
import com.senla.api.dao.GroupDao;
import com.senla.api.dao.PairDao;
import com.senla.api.dao.StudentDao;
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
	@Autowired
	StudentDao studentDao;

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
		Group group = groupDao.get(idGroup);
		Student student = studentDao.get(idStudent);
		student.setGroup(group);
		studentDao.update(student);
	}

	@Override
	public void removeStudentFromGroup(Long idStudent) {
		Student student = studentDao.get(idStudent);
		student.setGroup(null);
		studentDao.update(student);
	}

	@Override
	public void addstudentsToGroup(Long idGroup, List<Long> students) {
		Group group = groupDao.get(idGroup);
		List<Long> groupStudents = group.getStudents().stream().map(lection -> lection.getId())
				.collect(Collectors.toList());
		for (Long idStudent : students) {
			if (groupStudents.contains(idStudent)) {
				groupStudents.remove(idStudent);
			} else {
				Student student = studentDao.get(idStudent);
				student.setGroup(group);
				studentDao.update(student);
			}
		}
		for (Long idStudent : groupStudents) {
			Student student = studentDao.get(idStudent);
			student.setGroup(null);
			studentDao.update(student);
		}
	}

	@Override
	public List<Group> getGroupsByPairId(Long idPair) {
		return groupDao.getGroupsByPairId(idPair);
	}

	@Override
	public List<Group> getGroupsWithoutPair(Long idPair) {
		return groupDao.getGroupsWithoutPair(idPair);
	}

}
