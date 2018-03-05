package com.senla.web.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PairUpdateDto {
	private Long id;
	private String name;
	private Long time;
	private LocalDateTime date;
	private Long lection;
	private List<Long> groups;

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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getLection() {
		return lection;
	}

	public void setLection(Long lection) {
		this.lection = lection;
	}

	public List<Long> getGroups() {
		return groups;
	}

	public void setGroups(List<Long> groups) {
		this.groups = groups;
	}
}
