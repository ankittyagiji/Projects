package com.levent.consultantapi.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;

import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.levent.consultantapi.dto.UserRequestDto;
import com.levent.consultantapi.dto.converter.UserDtoConvertor;
import com.levent.consultantapi.exception.CustomException;

import com.levent.consultantapi.model.User;

import com.levent.consultantapi.service.UserService;

@Controller
public class LoginViewController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LoginViewController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserDtoConvertor userDtoConvertor;

	@GetMapping("/login")
	public ModelAndView login(ModelMap map) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		System.out.println("inside login get method");
		return mav;

	}

	@PostMapping("/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}

		model.addAttribute("errorMessge", errorMessge);
		return "login";
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("msg", "You are Successfully logged in");
		System.out.println("inside home method");
		return mav;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@RequestBody @Valid @ModelAttribute("user") UserRequestDto userRequestDto,
			Errors error, ModelMap modelMap) throws CustomException {

		ModelAndView mav = new ModelAndView();
		if (error.hasErrors()) {
			System.out.println("inside registerUser if method");
			modelMap.addAttribute("successMessage", "Please correct the errors in form");
			System.out.println("Error ==> " + error);
			mav.setViewName("register");
			return mav;

		}

		else {
			// save the user registration form
			System.out.println("inside registerUser else method");
			User user = new User();
			user = userDtoConvertor.convertUserRequestDtoToUser(userRequestDto);
			userService.createUser(user);
			modelMap.addAttribute("successMessage", "User created successfully!!!");
			mav.setViewName("success");
			return mav;
		}
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

	@GetMapping("/list")
	public String showUserLists(Model model) {
		model.addAttribute("user", userService.getUsers());
		return "userList";
	}

	/*
	 @GetMapping("delete/{id}")
	  public String deleteStudent(@PathVariable("id") long id, Model model) {
	  User user = userRepository.getById(id);
	  userRepository.deleteById(id);
	  model.addAttribute("user", userRepository.findAll());
	  return "userList";
	  }
	  */

	@SuppressWarnings("unused")
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
		userService.deleteUserById(id);
		model.addAttribute("user", userService.getUsers());
		return "userList";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}

	@PostMapping("update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid @ModelAttribute("user") UserRequestDto userRequestDto,
			BindingResult result, Model model) throws CustomException {

		if (result.hasErrors()) {
			userRequestDto.setId(id);
			return "updateUser";
		}

		User user = new User();
		user = userDtoConvertor.convertUserRequestDtoToUser(userRequestDto);
		userService.updateUserById(id, user);
		model.addAttribute("user", userService.getUsers());
		return "userList";
	}

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		System.out.println("inside welcome method");
		return mav;
	}

	@PostMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}
}