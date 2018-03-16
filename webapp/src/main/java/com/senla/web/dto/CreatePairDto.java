package com.senla.web.dto;

public class CreatePairDto {
	private String name;
	private Long lection;
	private String date;
	private Long time;

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

}
