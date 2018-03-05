package com.senla.dao.search;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PairSearchParams {
	private Long id;
	private LocalDateTime date;
	private String lection;
	private LocalTime startTime;
	private LocalTime endTime;

	public PairSearchParams(Long id, LocalDateTime date, String lection, LocalTime startTime, LocalTime endTime) {
		super();
		this.id = id;
		this.date = date;
		this.lection = lection;
		this.startTime = startTime;
		this.endTime = endTime;
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
