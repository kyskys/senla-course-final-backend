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
		public static final String ADMIN = "Admin";
		public static final String LECTURER = "Lecturer";
		public static final String STUDENT = "Student";
	}
}