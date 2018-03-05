package com.senla.dao.search;

import java.util.Arrays;

public enum SortParam {
	NAME("name"), ID("id"), DATE("date"), LECTURER_ID("lecturer"), PAIR_ID("pair"), EMAIL("email"), PHONE_NUMBER(
			"number"), STUDENT_ID("student"), LECTION_ID("lection"), TIME("time"), GROUP_ID("group"), COURSE_ID("course");

	private String value;

	private SortParam(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SortParam getValueOf(String value) {
		return Arrays.stream(SortParam.values()).filter(sortParam -> sortParam.getValue().equals(value)).findFirst()
				.orElse(null);
	}
}
