package com.demo.webclient.model;

import java.io.Serializable;
import javax.persistence.Transient;
import lombok.Data;

@Data
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = -6418611668962509808L;

	private String username;

}