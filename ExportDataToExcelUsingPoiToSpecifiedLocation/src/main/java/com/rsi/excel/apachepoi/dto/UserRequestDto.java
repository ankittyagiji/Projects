package com.rsi.excel.apachepoi.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserRequestDto {

	private Integer id;
	@Size(min = 5, max = 15, message = "LastName length should be b/w 5 and 15")
	@NotEmpty(message = "Please provide A FirstName")
	private String firstName;
	private String lastName;
	private String address;
}
