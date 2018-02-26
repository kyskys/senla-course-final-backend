package com.senla.api.service;

import com.senla.entity.Group;

public interface GroupService extends AbstractService<Group> {
	boolean addPairToGroup(Long idPair, Long idGroup);

	boolean removePairFromGroup(Long idPair, Long idGroup);

	boolean addStudentToGroup(Long idStudent, Long idGroup);

	boolean removeStudentFromGroup(Long idStudent, Long idGroup);

}
