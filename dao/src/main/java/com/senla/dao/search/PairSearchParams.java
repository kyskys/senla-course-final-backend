package com.senla.dao.search;

import java.time.LocalDateTime;

public class PairSearchParams {
	private Long id;
	private LocalDateTime date;
	private Long lection;
	private Long time;

	public PairSearchParams(Long id, LocalDateTime date, Long lection, Long time) {
		super();
		this.id = id;
		this.date = date;
		this.lection = lection;
		this.time = time;
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
