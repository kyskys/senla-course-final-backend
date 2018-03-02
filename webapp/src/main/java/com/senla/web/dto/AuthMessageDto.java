package com.senla.web.dto;

import com.senla.dao.util.AuthCodeEnum;

public class AuthMessageDto {
	private Integer code;
	private String token;

	public AuthMessageDto() {
	}

	public AuthMessageDto(AuthCodeEnum code, String token) {
		this.code = code.getCode();
		this.token = token;
	}

	public AuthMessageDto(AuthCodeEnum code) {
		this(code, null);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
