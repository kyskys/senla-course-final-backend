package com.senla.web.dto;

import com.senla.dao.util.CodeEnum;

public class CodeMessageDto {
	private Integer code;
	private String token;

	public CodeMessageDto() {
	}

	public CodeMessageDto(CodeEnum code, String token) {
		this.code = code.getCode();
		this.token = token;
	}

	public CodeMessageDto(CodeEnum code) {
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
