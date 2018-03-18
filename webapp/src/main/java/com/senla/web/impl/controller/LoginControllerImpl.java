package com.senla.web.impl.controller;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.dao.util.CodeEnum;
import com.senla.entity.Lecturer;
import com.senla.entity.Student;
import com.senla.entity.User;
import com.senla.entity.util.RoleEnum;
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

	/*
	 * @RequestMapping(value = "user/register", method = RequestMethod.POST)
	 * public CodeMessageDto registerStudent(@Valid @RequestBody UserRegisterDto
	 * dto) { try { userService.getUserByLogin(dto.getLogin()); } catch
	 * (NoResultException e) { return new CodeMessageDto(CodeEnum.LOGIN_EXIST);
	 * } Student student = new Student(); student.setEmail(dto.getEmail());
	 * student.setLogin(dto.getLogin()); student.setName(dto.getName());
	 * student.setPassword(dto.getPassword());
	 * student.setNumber(dto.getNumber()); studentService.create(student);
	 * 
	 * return new CodeMessageDto(CodeEnum.LOGIN_NOT_EXIST); }
	 */

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public CodeMessageDto registerLecturer(@Valid @RequestBody UserRegisterDto dto) {
		try {
			userService.getUserByLogin(dto.getLogin());
			return new CodeMessageDto(CodeEnum.LOGIN_EXIST);
		} catch (NoResultException e) {
			String role = dto.getRole();
			if (role.equals("student")) {
				Student student = new Student();
				student.setEmail(dto.getEmail());
				student.setLogin(dto.getLogin());
				student.setName(dto.getName());
				student.setPassword(dto.getPassword());
				student.setNumber(dto.getNumber());
				studentService.create(student);
				return new CodeMessageDto(CodeEnum.LOGIN_NOT_EXIST);
			} else if (role.equals("lecturer")) {
				Lecturer lecturer = new Lecturer();
				lecturer.setEmail(dto.getEmail());
				lecturer.setLogin(dto.getLogin());
				lecturer.setName(dto.getName());
				lecturer.setPassword(dto.getPassword());
				lecturer.setNumber(dto.getNumber());
				lecturerService.create(lecturer);
				return new CodeMessageDto(CodeEnum.LOGIN_NOT_EXIST);
			}
		}
		return new CodeMessageDto(CodeEnum.INVALID_INPUT);

	}

}
