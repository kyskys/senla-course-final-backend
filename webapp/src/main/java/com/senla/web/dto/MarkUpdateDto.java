package com.senla.web.dto;

public class MarkUpdateDto {
	private Long pair;
	private Long student;
	private Integer mark;

	public Long getPair() {
		return pair;
	}

	public void setPair(Long pair) {
		this.pair = pair;
	}

	public Long getStudent() {
		return student;
	}

	public void setStudent(Long student) {
		this.student = student;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}
