package com.senla.dao.search;

import java.time.LocalDateTime;

public class PairSearchParams {
	private Long id;
	private String name;
	private LocalDateTime date;
	private String lection;

	public PairSearchParams(Long id, String name, LocalDateTime date, String lection) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.lection = lection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
