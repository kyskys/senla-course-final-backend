package com.senla.web.impl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.holder.support.CurrentUserSupport;
import com.senla.web.api.controller.UserController;
import com.senla.web.dto.UserDetailsDto;

@RestController
public class UserControllerImpl implements UserController, CurrentUserSupport {

	@RequestMapping(value = "/api/profile", method = RequestMethod.GET)
	@Override
	public UserDetailsDto getUserDetails() {
		return new UserDetailsDto(getCurrentUser());
	}

}
