package com.rsi.excel.apachepoi.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rsi.excel.apachepoi.dto.UserDtoConverter;
import com.rsi.excel.apachepoi.dto.UserRequestDto;
import com.rsi.excel.apachepoi.exception.CustomException;
import com.rsi.excel.apachepoi.model.User;
import com.rsi.excel.apachepoi.service.UserService;
import com.rsi.excel.apachepoi.util.ExcelExporter;

@Controller
public class UserControllerForExportFile {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerForExportFile.class);
	
	@Autowired
	private UserDtoConverter userDtoConverter;

	@Autowired
	private UserService userService;

	@PostMapping(value="/export")
	public String exportToExcel(@RequestBody @ModelAttribute("user") UserRequestDto userRequestDto)
			throws IOException {

			User user = new User();
			try {
				user = userDtoConverter.convertUserRequestDtoToUser(userRequestDto);
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
			//to create user
			User user2 = userService.createUser(user);
			
			//get all user data to list
			ArrayList<User> listUsers = (ArrayList<User>) userService.getUsers();
			//get current user data to list
			User user1 = userService.getUserById(user2.getId());
			//insert data to file
			if((!listUsers.isEmpty()) && userRequestDto.getFirstName()!=null && userRequestDto.getFirstName()!=""
					&& userRequestDto.getFirstName().length() >= 5  && userRequestDto.getFirstName().length() <= 15)
			{
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
				LocalDateTime now = LocalDateTime.now();  
				String currentDateAndTime = dtf.format(now).toString();
				String headerValue = "allusers_"+ currentDateAndTime +".xlsx";
				
				ExcelExporter excelExporter = new ExcelExporter(user1);
				excelExporter.exportData(headerValue);
				return "File Saved Successfully";
				
			}
			
			else {
				LOGGER.info("Error ==> Either firstname is null or not valid");
				return "error";
			}
		
//return "File Saved Successfully";
	}
}
