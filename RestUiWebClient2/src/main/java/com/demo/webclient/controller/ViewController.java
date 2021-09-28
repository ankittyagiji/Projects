package com.demo.webclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.webclient.dto.UserRequestDto;
import com.demo.webclient.model.User;
import com.demo.webclient.service.MyService;
import reactor.core.publisher.Mono;

@Controller
public class ViewController {

	@Autowired
	private MyService myService;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	@PostMapping("/register")
	public ModelAndView registerUser(@RequestBody @ModelAttribute("user") UserRequestDto userRequestDto,
			ModelMap modelMap) {

		ModelAndView mav = new ModelAndView();
		Mono<String> str = myService.someRestCall22(userRequestDto);
		System.out.println("==========>Return string from service 1 : " + str.block());
		modelMap.addAttribute("successMessage", "User created successfully!!!");
		mav.setViewName("success");
		return mav;

	}

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.setViewName("register");
		mav.addObject("user", user);
		System.out.println("inside get register method");
		return mav;
	}
}