package com.senla.api.service;

import java.util.List;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;

public interface GroupService extends AbstractService<Group>, Searchable<GroupSearchParams, Group> {
	void addPairToGroup(Long idPair, Long idGroup);

	void removePairFromGroup(Long idPair, Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);

	List<Pair> getPairsByGroupId(Long idGroup);

	List<Student> getStudentsByGroupId(Long idGroup);
}
