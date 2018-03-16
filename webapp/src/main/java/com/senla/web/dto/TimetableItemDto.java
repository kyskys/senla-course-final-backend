package com.senla.web.dto;

import com.senla.dao.util.DateFormatterUtil;
import com.senla.entity.Pair;

public class TimetableItemDto {
	private String name;
	private String lection;
	private String startTime;
	private String endTime;
	private String date;

	public TimetableItemDto() {

	}

	public TimetableItemDto(Pair pair) {
		this.name = pair.getName();
		this.lection = pair.getLection().getName();
		this.startTime = DateFormatterUtil.getTimeAsString(pair.getTime().getStartTime());
		this.endTime = DateFormatterUtil.getTimeAsString(pair.getTime().getEndTime());
		this.date = DateFormatterUtil.getDateAsString(pair.getDate());
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
