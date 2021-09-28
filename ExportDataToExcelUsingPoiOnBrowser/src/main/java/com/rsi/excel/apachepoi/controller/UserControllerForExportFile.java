package com.rsi.excel.apachepoi.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rsi.excel.apachepoi.dto.UserDtoConverter;
import com.rsi.excel.apachepoi.dto.UserRequestDto;
import com.rsi.excel.apachepoi.exception.CustomException;
import com.rsi.excel.apachepoi.model.User;
import com.rsi.excel.apachepoi.repository.UserRepository;
import com.rsi.excel.apachepoi.util.ExcelExporter;

@Controller
public class UserControllerForExportFile {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDtoConverter userDtoConverter;

	@PostMapping("/export")
	public void exportToExcel(HttpServletResponse response,
			@RequestBody @ModelAttribute("user") UserRequestDto userRequestDto)
			throws IOException {
		
			try {
				userRepository.save(userDtoConverter.convertUserRequestDtoToUser(userRequestDto));
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
			//get user data to list
			ArrayList<User> listUsers = (ArrayList<User>) userRepository.findAll();
			//insert data to file
			if((!listUsers.isEmpty()) && userRequestDto.getFirstName()!=null && userRequestDto.getFirstName()!=""
					&& userRequestDto.getFirstName().length() >= 5  && userRequestDto.getFirstName().length() <= 15)
			{
				response.setContentType("application/octet-stream");
				String header = "Content-Disposition";
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
				LocalDateTime now = LocalDateTime.now();  
				String currentDateAndTime = dtf.format(now).toString();
				String headerValue = "attachment; filename=allusers_"+ currentDateAndTime +".xlsx";
				
				response.setHeader(header, headerValue);
				ExcelExporter excelExporter = new ExcelExporter(listUsers);
				excelExporter.exportData(response);
				
			}
			
			else {
				System.out.println("Either firstname is null or not valid");
			}
		

	}
}
