package com.senla.api.dao;

import java.util.List;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;

public interface GroupDao extends AbstractDao<Group>, Searchable<GroupSearchParams, Group> {

	List<Pair> getPairsByGroupId(Long idGroup);

	List<Student> getStudentsByGroupId(Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);

}
