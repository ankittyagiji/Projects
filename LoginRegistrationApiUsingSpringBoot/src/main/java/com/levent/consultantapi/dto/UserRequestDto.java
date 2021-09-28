package com.levent.consultantapi.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

	private Integer id;
	
	private String firstName;
	
	@Size(min = 5, max = 15, message = "LastName length should be b/w 5 and 15")
	private String lastName;
	
	private String pincode;
	
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	private String address;
	
	private String mobile;
	
	@Column(name = "password", nullable = false, updatable = false)
	private String password;
	
	private String uuid;
	
	@CreationTimestamp
	@Column(name = "createDateTime", nullable = false, updatable = false)
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

}