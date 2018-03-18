package com.senla.web.dto.pair;

import com.senla.dao.util.DateFormatterUtil;
import com.senla.entity.Pair;

public class PairGetDto {
	private Long id;
	private String name;
	private String date;
	private String lection;
	private String startTime;
	private String endTime;

	public PairGetDto() {

	}

	public PairGetDto(Pair pair) {
		this.id = pair.getId();
		this.name = pair.getName();
		this.date = DateFormatterUtil.getDateAsString(pair.getDate());
		this.lection = pair.getLection().getName();
		this.startTime = DateFormatterUtil.getTimeAsString(pair.getTime().getStartTime());
		this.endTime = DateFormatterUtil.getTimeAsString(pair.getTime().getEndTime());
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

	public String getLection() {
		return lection;
	}

	public void setLection(String lection) {
		this.lection = lection;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
