package com.senla.web.dto;

import com.senla.entity.Lection;

public class CourseLectionDto {
	private Long id;
	private String name;
	private Long pair;

	public CourseLectionDto() {

	}

	public CourseLectionDto(Lection lection) {
		this.id = lection.getId();
		if (lection.getName() != null) {
			this.name = lection.getName();
		}
		if (lection.getPair() != null) {
			this.pair = lection.getPair().getId();
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

	public Long getPair() {
		return pair;
	}

	public void setPair(Long pair) {
		this.pair = pair;
	}

}
