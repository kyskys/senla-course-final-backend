package com.senla.dao.util;

public enum CodeEnum {
	SUCCESS_AUTH(3000), WRONG_PASSWORD(3001), LOGIN_NOT_EXIST(3002), LOGIN_EXIST(3003), INVALID_INPUT(3004);
	int code;

	CodeEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
