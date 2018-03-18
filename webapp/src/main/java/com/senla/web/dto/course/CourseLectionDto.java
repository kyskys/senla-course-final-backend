package com.senla.web.dto.course;

import com.senla.entity.Lection;

public class CourseLectionDto {
	private Long id;
	private String name;

	public CourseLectionDto() {

	}

	public CourseLectionDto(Lection lection) {
		this.id = lection.getId();
		if (lection.getName() != null) {
			this.name = lection.getName();
		}
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
