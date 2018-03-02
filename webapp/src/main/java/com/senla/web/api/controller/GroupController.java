package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.GroupDto;
import com.senla.web.dto.GroupPairDto;
import com.senla.web.dto.GroupStudentDto;
import com.senla.web.dto.CreateGroupOrLectionDto;

public interface GroupController {
	GroupDto getGroup(Long id);

	void createGroup(CreateGroupOrLectionDto dto);

	void deleteGroup(Long id);

	void updateGroup(GroupDto dto, Long id);

	List<GroupDto> getAllGroups();

	List<GroupDto> search(String sortBy, Long id, String name, Integer limit, Integer offset, boolean asc);

	List<GroupPairDto> getPairsByGroupId(Long idGroup);

	List<GroupStudentDto> getStudentsByGroupId(Long idGroup);

	void addPairToGroup(Long idPair, Long idGroup);

	void removePairFromGroup(Long idPair, Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);


}
