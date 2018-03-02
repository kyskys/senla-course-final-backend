package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senla.api.service.GroupService;
import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Group;
import com.senla.web.api.controller.GroupController;
import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.GroupDto;
import com.senla.web.dto.GroupPairDto;
import com.senla.web.dto.GroupStudentDto;

public class GroupControllerImpl implements GroupController {
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/api/group/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public GroupDto getGroup(@PathVariable("id") Long id) {
		return new GroupDto(groupService.get(id));
	}

	@RequestMapping(value = "/api/group/", method = RequestMethod.PUT)
	@Override
	public void createGroup(@RequestBody CreateGroupOrLectionDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		groupService.create(group);
	}

	@RequestMapping(value = "/api/group/{id}", method = RequestMethod.DELETE)
	@Override
	public void deleteGroup(@PathVariable("id") Long id) {
		Group group = new Group();
		group.setId(id);
		groupService.delete(group);
	}

	@RequestMapping(value = "/api/group/{id}", method = RequestMethod.POST)
	@Override
	public void updateGroup(GroupDto dto, @PathVariable("id") Long id) {
		Group group = new Group();
		group.setId(id);
		group.setName(dto.getName());
		List<Long> students = dto.getStudents();
		if (students != null) {
			for (Long idStudent : students) {
				groupService.addStudentToGroup(idStudent, id);
			}
		}
		groupService.update(group);
	}

	@RequestMapping(value = "/api/group/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<GroupDto> getAllGroups() {
		return groupService.getAll().stream().map(GroupDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/group/search", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<GroupDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		GroupSearchParams searchParam = new GroupSearchParams(id, name);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<GroupDto> result = groupService.search(sortParam, searchParam, limit, offset, asc).stream().map(GroupDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "/api/group/{id}/pair/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<GroupPairDto> getPairsByGroupId(@PathVariable("id") Long idGroup) {
		return groupService.getPairsByGroupId(idGroup).stream().map(GroupPairDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/group/{id}student/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<GroupStudentDto> getStudentsByGroupId(@PathVariable("id") Long idGroup) {
		return groupService.getStudentsByGroupId(idGroup).stream().map(GroupStudentDto::new)
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/group/{group}/add/pair/{pair}", method = RequestMethod.GET)
	@Override
	public void addPairToGroup(@PathVariable("pair") Long idPair, @PathVariable("group") Long idGroup) {
		groupService.addPairToGroup(idPair, idGroup);
	}

	@RequestMapping(value = "/api/group/{group}/remove/pair/{pair}", method = RequestMethod.GET)
	@Override
	public void removePairFromGroup(@PathVariable("pair") Long idPair, @PathVariable("group") Long idGroup) {
		groupService.removePairFromGroup(idPair, idGroup);
	}

	@RequestMapping(value = "/api/group/{group}/add/student/{student}", method = RequestMethod.GET)
	@Override
	public void addStudentToGroup(@PathVariable("student") Long idStudent, @PathVariable("group") Long idGroup) {
		groupService.addStudentToGroup(idStudent, idGroup);
	}

	@RequestMapping(value = "/api/group/{group}/remove/student/{student}", method = RequestMethod.GET)
	@Override
	public void removeStudentFromGroup(@PathVariable("student") Long idStudent) {
		groupService.removeStudentFromGroup(idStudent);
	}

}
