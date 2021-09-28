package com.rsi.excel.apachepoi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rsi.excel.apachepoi.model.User;

@Controller
public class ViewController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);


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