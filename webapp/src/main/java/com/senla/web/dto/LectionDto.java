package com.senla.web.dto;

import com.senla.entity.Lection;

public class LectionDto {
	private Long course;
	private String name;
	private Long pair;

	public LectionDto() {

	}

	public LectionDto(Lection lection) {
		this.name = lection.getName();
		if (lection.getCourse() != null) {
			this.course = lection.getCourse().getId();
		}
		if (lection.getPair() != null) {
			this.pair = lection.getPair().getId();
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

	public Long getPair() {
		return pair;
	}

	public void setPair(Long pair) {
		this.pair = pair;
	}

}
