package com.rsi.kafka.consumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.service.UserService;


public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	
	@Value("${kafka.topic.json}")
	private String jsonTopic;
	
	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;
	
	@Value("${spring.kafka.consumer.auto-offset-reset}")
	private String offsetId;
	
	@Autowired
	private ReceiverConfig receiverConfig;
	
	
	static KafkaConsumer<String, UserDto> kafkaConsumer;

	public static ArrayList<UserDto> userDtos = new ArrayList<UserDto>();

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	
	@Autowired
	private UserService userService;	

	/*
	 * private UserServiceImpl userServiceImpl;
	 * 
	 * public Consumer(UserServiceImpl userServiceImpl) { this.userServiceImpl =
	 * userServiceImpl; }
	 * 
	 * public Consumer() {
	 * 
	 * }
	 */

	@KafkaListener(topics = "mytopic", groupId = "mygroup", containerFactory = "kafkaListenerContainerFactory")
	public void receive(UserDto userDto) {

		Map<String, Object> props2 = receiverConfig.consumerConfigs();
		
		System.out.println("=========Props Are================"+props2);
		kafkaConsumer = new KafkaConsumer<>(props2);

		kafkaConsumer.subscribe(Collections.singletonList(jsonTopic));// Subscribe to the topic.

		ConsumerRecords<String, UserDto> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(4000));

		consumerRecords.forEach(record -> {
			LOGGER.info("Consumer Record===========> ");

			System.out.println("record  key ======> " + record.key());
			System.out.println("record value =======> " + record.value());
			userDtos.add(userDto);
			System.out.println("record  partition ======> " + record.partition());
			System.out.println("record offset =======> " + record.offset());

		});
		// Commit last offset
		kafkaConsumer.commitAsync();

	}

	public void kafkaGetConsumerRecord() throws CustomException {
		userService.createUser(userDtos);

	}

}