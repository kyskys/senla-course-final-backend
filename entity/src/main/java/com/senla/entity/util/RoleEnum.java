package com.senla.entity.util;

public enum RoleEnum {

	LECTURER(Values.LECTURER), STUDENT(Values.STUDENT), ADMIN(Values.LECTURER);

	private String value;

	RoleEnum(String roleValue) {
		this.value = roleValue;
	}

	public String getValue() {
		return this.value;
	}

	public static class Values {
		public static final String ADMIN = "ADMIN";
		public static final String LECTURER = "LECTURER";
		public static final String STUDENT = "STUDENT";
	}
}
