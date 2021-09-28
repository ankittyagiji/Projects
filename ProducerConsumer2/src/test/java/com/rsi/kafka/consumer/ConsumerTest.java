package com.rsi.kafka.consumer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rsi.kafka.ProducerConsumerApplication;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerConsumerApplication.class)
public class ConsumerTest {

	@InjectMocks
	Consumer consumer;

	@Mock
	UserService userService;

	@Mock
	UserDto userDto;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userDto = new UserDto();
		userDto.setUserName("Jaljala");
		userDto.setPassword("jaljala@321");
	}

	@Test
	public void bgetAndSaveRecordTestCase() throws Exception {

		Consumer.userDtos.add(userDto);

		consumer.kafkaGetConsumerRecord();
		verify(userService, times(1)).createUser(Consumer.userDtos);

	}
}
