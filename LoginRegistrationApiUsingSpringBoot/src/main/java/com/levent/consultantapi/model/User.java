package com.levent.consultantapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Table(name = "User11")
@Data
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = -6418611668962509808L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;

	private String lastName;

	private String pincode;

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