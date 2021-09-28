package com.levent.consultantapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import com.levent.consultantapi.dto.UserRequestDto;
import com.levent.consultantapi.dto.converter.UserDtoConvertor;
import com.levent.consultantapi.exception.CustomException;

import com.levent.consultantapi.model.User;

import com.levent.consultantapi.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	public LoginController() {
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserDtoConvertor userDtoConvertor;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> list() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/users/{uuid}", method = RequestMethod.GET)
	public User getByUuid(@PathVariable("uuid") String uuid) {
		return userService.findByUuid(uuid);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestBody @Valid UserRequestDto userDto) throws CustomException {
		User user = new User();
		user = userDtoConvertor.convertUserRequestDtoToUser(userDto);
		userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Integer id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}

	/*
	 * @RequestMapping(value = "users/{uuid}", method = RequestMethod.DELETE) *
	 * public void delete(@PathVariable Long id) { * userService.deleteUserById(id);
	 * * }
	 */

}
