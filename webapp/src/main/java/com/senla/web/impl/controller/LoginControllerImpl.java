package com.senla.web.impl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.util.CodeEnum;
import com.senla.entity.Lecturer;
import com.senla.entity.Person;
import com.senla.entity.Student;
import com.senla.service.api.LecturerService;
import com.senla.service.api.StudentService;
import com.senla.service.api.UserService;
import com.senla.web.dto.CodeMessageDto;
import com.senla.web.dto.UserCredsDto;
import com.senla.web.dto.UserRegisterDto;
import com.senla.web.util.JWTManager;

@RestController
public class LoginControllerImpl {

	@Autowired
	StudentService studentService;
	@Autowired
	LecturerService lecturerService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CodeMessageDto login(@Valid @RequestBody UserCredsDto dto) {
		CodeEnum code = userService.checkUser(dto.getLogin(), dto.getPassword());
		if (code == CodeEnum.SUCCESS_AUTH) {
			return new CodeMessageDto(CodeEnum.SUCCESS_AUTH,
					JWTManager.createToken(userService.getUserByLogin(dto.getLogin())));
		} else {
			return new CodeMessageDto(code);
		}
	}

	@RequestMapping(value = "/user/registrate", method = RequestMethod.POST)
	public CodeMessageDto registrageUser(@Valid @RequestBody UserRegisterDto dto) {
		if (!userService.isUserExist(dto.getLogin())) {
			String role = dto.getRole();
			Person person = role.equals("student") ? new Student() : new Lecturer();
			person.setEmail(dto.getEmail());
			person.setLogin(dto.getLogin());
			person.setName(dto.getName());
			person.setPassword(dto.getPassword());
			person.setNumber(dto.getNumber());
			if (role.equals("student")) {
				studentService.create((Student) person);
			} else {
				lecturerService.create((Lecturer) person);
			}
			return new CodeMessageDto(CodeEnum.LOGIN_NOT_EXIST);
		} else {
			return new CodeMessageDto(CodeEnum.LOGIN_EXIST);
		}
	}
}
