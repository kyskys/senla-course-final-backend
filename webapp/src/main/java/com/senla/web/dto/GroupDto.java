package com.senla.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senla.entity.Group;

public class GroupDto {
	private String name;
	private List<Long> students;
	private List<Long> pairs;

	public GroupDto() {

	}

	public GroupDto(Group group) {
		this.name = group.getName();
		if (group.getPairs() != null) {
			this.pairs = group.getPairs().stream().map(pair -> pair.getId()).collect(Collectors.toList());
		}
		if (group.getStudents() != null) {
			this.students = group.getStudents().stream().map(student -> student.getId()).collect(Collectors.toList());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getStudents() {
		return students;
	}

	public void setStudents(List<Long> students) {
		this.students = students;
	}

	public List<Long> getPairs() {
		return pairs;
	}

	public void setPairs(List<Long> pairs) {
		this.pairs = pairs;
	}

}
