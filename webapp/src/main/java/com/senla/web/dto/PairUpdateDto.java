package com.senla.web.dto;

public class PairUpdateDto {
	private Long id;
	private String name;
	private Long time;
	private String date;
	private Long lection;

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

	public Long getLection() {
		return lection;
	}

	public void setLection(Long lection) {
		this.lection = lection;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
