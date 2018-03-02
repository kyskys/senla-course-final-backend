package com.senla.dao.search;

public class LectionSearchParams {
	private Long id;
	private String name;
	private Long pair;

	public LectionSearchParams(Long id, String name, Long pair) {
		super();
		this.id = id;
		this.name = name;
		this.pair = pair;
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

	public Long getPair() {
		return pair;
	}

	public void setPair(Long pair) {
		this.pair = pair;
	}
}
