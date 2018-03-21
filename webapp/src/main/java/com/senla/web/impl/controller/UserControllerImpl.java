package com.senla.web.impl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.entity.User;
import com.senla.holder.support.CurrentUserSupport;
import com.senla.service.api.UserService;
import com.senla.web.dto.UserDetailsDto;

@RestController
@RequestMapping("/api/user/")
public class UserControllerImpl implements CurrentUserSupport {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "profile/details/", method = RequestMethod.GET)
	public UserDetailsDto getUserDetails() {
		return new UserDetailsDto(getCurrentUser());
	}

	@RequestMapping(value = "name", method = RequestMethod.GET)
	public String getUserName() {
		return "{\"name\" : \"" + getCurrentUser().getName() + "\"}";
	}

	@RequestMapping(value="role",method=RequestMethod.GET) 
	public String getUserRole() {
		System.out.println(getCurrentUser().getRole().getValue());
		return "{\"role\" : \"" + getCurrentUser().getRole().getValue() + "\"}";
	}
	
	@RequestMapping(value = "profile/details/", method = RequestMethod.POST)
	private UserDetailsDto updateUserDetails(@Valid @RequestBody UserDetailsDto dto) {
		User user = userService.get(getCurrentUser().getId());
		String email = dto.getEmail();
		if (!StringUtils.isEmpty(email)) {
			user.setEmail(email);
		}
		String name = dto.getName();
		if (!StringUtils.isEmpty(name)) {
			user.setName(name);
		}
		String number = dto.getNumber();
		if (!StringUtils.isEmpty(number)) {
			user.setNumber(number);
		}
		userService.update(user);
		return new UserDetailsDto(user);
	}
	
}
