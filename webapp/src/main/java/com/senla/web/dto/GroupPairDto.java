package com.senla.web.dto;

import java.time.LocalDateTime;

import com.senla.entity.Pair;

public class GroupPairDto {
	private Long id;
	private LocalDateTime date;
	private Long lection;
	private Long time;

	public GroupPairDto() {

	}

	public GroupPairDto(Pair pair) {
		this.id = pair.getId();
		this.lection = pair.getLection().getId();
		this.time = pair.getTime().getId();
		LocalDateTime date = pair.getDate();
		if (date != null) {
			this.date = date;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
