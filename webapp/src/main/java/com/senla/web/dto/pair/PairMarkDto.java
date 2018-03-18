package com.senla.web.dto.pair;

import com.senla.entity.Mark;

public class PairMarkDto {
	private Long id;
	private String student;
	private Integer mark;

	public PairMarkDto() {

	}

	public PairMarkDto(Mark mark) {
		this.id = mark.getId();
		this.student = mark.getStudent().getName();
		this.mark = mark.getMark();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
