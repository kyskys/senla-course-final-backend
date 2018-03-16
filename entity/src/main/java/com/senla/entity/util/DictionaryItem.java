package com.senla.entity.util;

public class DictionaryItem {
	private Long id;
	private String name;

	public DictionaryItem(Long id, String name) {
		this.setId(id);
		this.name = name;
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
}
