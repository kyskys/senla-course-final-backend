package com.senla.web.dto;

import com.senla.entity.Lection;

public class LectionDto {
	private Long course;
	private String name;

	public LectionDto() {

	}

	public LectionDto(Lection lection) {
		this.name = lection.getName();
		if (lection.getCourse() != null) {
			this.course = lection.getCourse().getId();
		}
	}

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
