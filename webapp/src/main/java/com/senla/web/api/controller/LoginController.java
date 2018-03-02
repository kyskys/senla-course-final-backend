package com.senla.web.api.controller;

import com.senla.web.dto.AuthMessageDto;
import com.senla.web.dto.UserCredsDto;
import com.senla.web.dto.UserRegisterDto;

public interface LoginController {
	AuthMessageDto login(UserCredsDto dto);

	void registerStudent(UserRegisterDto dto);

	void registerLecturer(UserRegisterDto dto);
}
