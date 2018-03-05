package com.senla.web.api.controller;

import com.senla.web.dto.UserDetailsDto;

public interface UserController {
	UserDetailsDto getUserDetails();

	String getUserName();
}
