package com.senla.web.dto;

import com.senla.entity.Group;

public class GroupGetDto {
	private Long id;
	private String name;

	public GroupGetDto() {

	}

	public GroupGetDto(Group group) {
		this.id = group.getId();
		this.name = group.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
