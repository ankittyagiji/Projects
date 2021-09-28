package com.rsi.kafka.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {
	private String id;
	private String userName;
	private String password;

}
