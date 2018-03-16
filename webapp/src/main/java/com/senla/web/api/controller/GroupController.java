package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.GroupDto;
import com.senla.web.dto.GroupGetDto;
import com.senla.web.dto.GroupPairDto;
import com.senla.web.dto.GroupStudentDto;
import com.senla.web.dto.CreateGroupOrLectionDto;

public interface GroupController {
	GroupGetDto getGroup(Long id);

	GroupGetDto createGroup(CreateGroupOrLectionDto dto);

	void deleteGroup(Long id);

	List<GroupGetDto> getAllGroups();

	List<GroupGetDto> search(String sortBy, Long id, String name, Integer limit, Integer offset, boolean asc);

	List<GroupPairDto> getPairsByGroupId(Long idGroup);

	List<GroupStudentDto> getStudentsByGroupId(Long idGroup);

	void addPairToGroup(Long idPair, Long idGroup);

	void removePairFromGroup(Long idPair, Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);

	Long groupCount(Long id, String name);

	void updateGroup(Long id, GroupDto dto);


}
