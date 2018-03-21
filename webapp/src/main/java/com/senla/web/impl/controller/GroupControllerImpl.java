package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Group;
import com.senla.entity.util.DictionaryItem;
import com.senla.service.api.GroupService;
import com.senla.web.dto.group.GroupCreateDto;
import com.senla.web.dto.group.GroupDto;
import com.senla.web.dto.group.GroupGetDto;
import com.senla.web.dto.group.GroupPairDto;
import com.senla.web.dto.group.GroupStudentDto;
import com.senla.web.dto.student.StudentGetDto;

@RestController
@RequestMapping("/api/group/")
public class GroupControllerImpl {
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public GroupGetDto getGroup(@PathVariable("id") Long id) {
		return new GroupGetDto(groupService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public GroupGetDto createGroup(@Valid @RequestBody GroupCreateDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		return new GroupGetDto(groupService.create(group));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteGroup(@PathVariable("id") Long id) {
		Group group = new Group();
		group.setId(id);
		groupService.delete(group);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateGroup(@PathVariable("id") Long id, @Valid @RequestBody GroupDto dto) {
		Group group = groupService.get(id);
		String name = dto.getName();
		if (!StringUtils.isEmpty(name)) {
			group.setName(name);
		}
		groupService.update(group);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<GroupGetDto> getAllGroups() {
		return groupService.getAll().stream().map(GroupGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<GroupGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		GroupSearchParams searchParam = new GroupSearchParams(id, name);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<GroupGetDto> result = groupService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(GroupGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long groupCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name) {
		GroupSearchParams searchParam = new GroupSearchParams(id, name);
		return groupService.count(searchParam);
	}

	@RequestMapping(value = "{group}/add/pair/{pair}", method = RequestMethod.GET)
	public void addPairToGroup(@PathVariable("pair") Long idPair, @PathVariable("group") Long idGroup) {
		groupService.addPairToGroup(idPair, idGroup);
	}

	@RequestMapping(value = "{group}/remove/pair/{pair}", method = RequestMethod.GET)
	public void removePairFromGroup(@PathVariable("pair") Long idPair, @PathVariable("group") Long idGroup) {
		groupService.removePairFromGroup(idPair, idGroup);
	}

	@RequestMapping(value = "{group}/add/student/{student}", method = RequestMethod.GET)
	public void addStudentToGroup(@PathVariable("student") Long idStudent, @PathVariable("group") Long idGroup) {
		groupService.addStudentToGroup(idStudent, idGroup);
	}

	@RequestMapping(value = "{group}/remove/student/{student}", method = RequestMethod.GET)
	public void removeStudentFromGroup(@PathVariable("student") Long idStudent) {
		groupService.removeStudentFromGroup(idStudent);
	}

	@RequestMapping(value = "{id}/add/student", method = RequestMethod.POST)
	public void addStudentsToGroup(@PathVariable("id") Long idGroup, @RequestBody List<Long> students) {
		groupService.addstudentsToGroup(idGroup, students);
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return groupService.getDictionary();
	}

	@RequestMapping(value = "pair/{pair}", method = RequestMethod.GET)
	public List<GroupGetDto> getGroupsByPairId(@PathVariable("pair") Long idPair) {
		List<GroupGetDto> result = groupService.getGroupsByPairId(idPair).stream().map(GroupGetDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "/nopair/{pair}", method = RequestMethod.GET)
	public List<GroupGetDto> getGroupsWithoutPair(@PathVariable("pair") Long idPair) {
		List<GroupGetDto> result = groupService.getGroupsWithoutPair(idPair).stream().map(GroupGetDto::new)
				.collect(Collectors.toList());
		return result;
	}
}
