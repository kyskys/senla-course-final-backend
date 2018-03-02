package com.senla.dao.search;

public class MarkSearchParams {
	private Long id;
	private Long pair;
	private Long student;

	public MarkSearchParams(Long id, Long pair, Long student) {
		super();
		this.id = id;
		this.pair = pair;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}
