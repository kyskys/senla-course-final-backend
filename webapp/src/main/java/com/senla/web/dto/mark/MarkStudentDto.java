package com.senla.web.dto.mark;

import com.senla.entity.Mark;

public class MarkStudentDto {
	private Long id;
	private String pair;
	private Integer mark;

	public MarkStudentDto() {

	}

	public MarkStudentDto(Mark mark) {
		this.id = mark.getId();
		this.pair = mark.getPair().getName();
		this.mark=mark.getMark();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
