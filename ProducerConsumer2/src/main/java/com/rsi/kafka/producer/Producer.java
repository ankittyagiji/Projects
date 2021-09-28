package com.rsi.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.dtovalidation.DtoValidation;

public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

	@Value("${kafka.topic.json}")
	private String jsonTopic;

	@Autowired
	private KafkaTemplate<String, UserDto> kafkaTemp;
	
	@Autowired
	private DtoValidation dtoValidation;

	public void publishToTopic(UserDto userDto) {
		LOGGER.info("==========>sending UserDto Object fields=====================<", userDto.toString());
		dtoValidation.checkValidations(userDto);
		System.out.println(jsonTopic);
		kafkaTemp.send(jsonTopic, userDto);
        System.out.println(jsonTopic);
	}

}
