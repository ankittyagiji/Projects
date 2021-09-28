package com.demo.webclient.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webclient.dto.UserRequestDto;

@RestController
@RequestMapping("/api")
public class LoginController {	

	@RequestMapping(value = "/createUser1", method = RequestMethod.GET)
	@ResponseBody
	public String createUser1(@RequestBody UserRequestDto userDto){
		String s = "User : " + userDto.getUsername();
		return s;

	}

}
