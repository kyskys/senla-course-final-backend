package com.senla.web.impl.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.senla.entity.User;
import com.senla.holder.support.CurrentUserSupport;
import com.senla.service.api.UserService;
import com.senla.web.dto.UserDetailsDto;

@RestController
public class UserControllerImpl implements CurrentUserSupport {

	@RequestMapping(value = "/api/user/profile/creds", method = RequestMethod.GET)
	public UserDetailsDto getUserDetails() {
		return new UserDetailsDto(getCurrentUser());
	}

	@RequestMapping(value = "/api/user/name", method = RequestMethod.GET)
	public String getUserName() {
		return "{\"name\" : \"" + getCurrentUser().getName() + "\"}";
	}

	@RequestMapping(value = "/api/profile/details/{id}", method = RequestMethod.POST)
	private void updateUserDetails(@Valid @RequestBody UserDetailsDto dto) {
		User user = getCurrentUser();
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

	}

}
