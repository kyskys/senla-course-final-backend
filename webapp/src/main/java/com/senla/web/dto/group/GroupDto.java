package com.senla.web.dto.group;

import javax.validation.constraints.Size;

import com.senla.entity.Group;

public class GroupDto {
	@Size(max = 45)
	private String name;

	public GroupDto() {

	}

	public GroupDto(Group group) {
		this.name = group.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
