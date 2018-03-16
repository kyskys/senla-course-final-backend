package com.senla.api.service;

import java.util.List;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;

public interface GroupService extends AbstractService<Group>, Searchable<GroupSearchParams, Group> {
	void addPairToGroup(Long idPair, Long idGroup);

	void removePairFromGroup(Long idPair, Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);

	void addstudentsToGroup(Long idGroup, List<Long> students);

	List<Group> getGroupsByPairId(Long idPair);

	List<Group> getGroupsWithoutPair(Long idPair);
}
