package com.senla.web.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.LecturerService;
import com.senla.api.service.StudentService;
import com.senla.api.service.UserService;
import com.senla.dao.util.AuthCodeEnum;
import com.senla.entity.Lecturer;
import com.senla.entity.Student;
import com.senla.web.api.controller.LoginController;
import com.senla.web.dto.AuthMessageDto;
import com.senla.web.dto.UserCredsDto;
import com.senla.web.dto.UserRegisterDto;
import com.senla.web.util.JWTManager;

@RestController
public class LoginControllerImpl implements LoginController {

	@Autowired
	StudentService studentService;
	@Autowired
	LecturerService lecturerService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Override
	public AuthMessageDto login(@RequestBody UserCredsDto dto) {
		AuthCodeEnum code = userService.checkUser(dto.getLogin(), dto.getPassword());
		if (code == AuthCodeEnum.SUCCESS_AUTH) {
			return new AuthMessageDto(AuthCodeEnum.SUCCESS_AUTH, JWTManager.createToken(userService.getUserByLogin(dto.getLogin())));
		} else {
			return new AuthMessageDto(code);
		}
	}

	@RequestMapping(value = "/register/student", method = RequestMethod.POST)
	@Override
	public void registerStudent(@RequestBody UserRegisterDto dto) {
		Student student = new Student();
		student.setEmail(dto.getEmail());
		student.setLogin(dto.getLogin());
		student.setName(dto.getName());
		student.setPassword(dto.getPassword());
		student.setNumber(dto.getNumber());
		studentService.create(student);
	}

	@RequestMapping(value = "/register/lecturer", method = RequestMethod.POST)
	@Override
	public void registerLecturer(@RequestBody UserRegisterDto dto) {
		Lecturer lecturer = new Lecturer();
		lecturer.setEmail(dto.getEmail());
		lecturer.setLogin(dto.getLogin());
		lecturer.setName(dto.getName());
		lecturer.setPassword(dto.getPassword());
		lecturer.setNumber(dto.getNumber());
		lecturerService.create(lecturer);
	}

}
