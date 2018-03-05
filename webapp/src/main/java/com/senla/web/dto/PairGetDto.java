package com.senla.web.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.senla.entity.Pair;

public class PairGetDto {
	private Long id;
	private String name;
	private LocalDateTime date;
	private String lection;
	private LocalTime startTime;
	private LocalTime endTime;

	public PairGetDto() {

	}

	public PairGetDto(Pair pair) {
		this.id = pair.getId();
		this.name = pair.getName();
		this.date = pair.getDate();
		this.lection = pair.getLection().getName();
		this.startTime = pair.getTime().getStartTime();
		this.endTime = pair.getTime().getEndTime();
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getLection() {
		return lection;
	}

	public void setLection(String lection) {
		this.lection = lection;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}
