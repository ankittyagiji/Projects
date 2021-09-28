package com.rsi.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.kafka.consumer.Consumer;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.model.User;
import com.rsi.kafka.producer.Producer;
import com.rsi.kafka.response.SuccessResponse;
import com.rsi.kafka.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/kafka")
@Api(value="/kafka", description="Operations pertaining to users",tags = "User Management")
public class KafkaController {

	@Autowired
	private Producer producer;

	@Autowired
	private UserService userService;

	@Autowired
	private Consumer consumer;

	@PostMapping(value = "/sendUserCredToKafka")
	@ResponseBody
	@ApiOperation(value = "Sends UserCred to  Kafka Topic" , notes = "Method Used to Send UserCredentials to  Kafka Topic" , tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Data Sent on Kafka Topic"),
			@ApiResponse(code = 404 , message = "Invalid user credentials"),
			@ApiResponse(code = 500 , message = "Internal Server  Error")			
	})
	public SuccessResponse sendUserCredToKafka(@RequestBody UserDto userDto) {
		producer.publishToTopic(userDto);
		return new SuccessResponse("Record  Sent On Kafka Topic Successfully", Boolean.TRUE);
	}

	@PostMapping(value = "/getAndSaveRecord")
	@ResponseBody
	@ApiOperation(value = "Get and Save UserCred to  Db" , notes = "Method Used to get and save UserCredentials to  Db" , tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "User Record Inserted"),
			@ApiResponse(code = 404 , message = "Invalid user credentials"),
			@ApiResponse(code = 500 , message = "Internal Server  Error")			
	})
	public SuccessResponse getAndSaveRecord() throws CustomException{

		consumer.kafkaGetConsumerRecord();
		
		return new SuccessResponse("Record Inserted Successfully",Boolean.TRUE);
	}

	@GetMapping(value = "/getUserDetails")
	@ApiOperation(value = "Retrieves  All UserCred from Db" , notes = "Method Used to Retrieve UserCredentials from Db" , tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Records Fetched Successfully"),
			@ApiResponse(code = 404 , message = "Service down or Db is empty"),
			@ApiResponse(code = 500 , message = "Internal Server  Error")			
	})
	public List<User> getAllUserCredentialFromDb() {

		return userService.findAll();
	}

	
/*
 * @GetMapping(value = "/getUserDetails") public SuccessResponse
 * getAllUserCredentialFromDb() { List<User> userList = userService.findAll();
 * return new
 * SuccessResponse("Total records count ==> "+userList.size(),Boolean.TRUE); }
 */
}
