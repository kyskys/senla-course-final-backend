package com.senla.web.dto;

import com.senla.entity.Mark;

public class MarkGetDto {
	private Long id;
	private String pair;
	private String student;
	private Integer mark;

	public MarkGetDto() {

	}

	public MarkGetDto(Mark mark) {
		this.id = mark.getId();
		this.pair = mark.getPair().getName();
		this.student = mark.getStudent().getName();
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
