package com.rsi.kafka.spout;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapper Message class to store the attribtues fetched in Mapper Bolt
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapperMessage implements Serializable {

    private static final long serialVersionUID = 7193413872188312002L;
    private String id;
	private String userName;
	private String password;
   
}