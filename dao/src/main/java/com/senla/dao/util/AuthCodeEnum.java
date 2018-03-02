package com.senla.dao.util;

public enum AuthCodeEnum {
	SUCCESS_AUTH(3000), WRONG_PASSWORD(3001), LOGIN_NOT_EXIST(3002);
	int code;

	AuthCodeEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
