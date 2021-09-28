package com.rsi.kafka.controller;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rsi.kafka.ProducerConsumerApplication;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.model.User;
import com.rsi.kafka.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerConsumerApplication.class)
public class KafkaControllerTest {

	@InjectMocks
	KafkaController kafkaController = new KafkaController();

	@Mock
	UserService userService;

	@Mock
	UserDto userDto;

	@Before
	public void setup() throws IOException {
		MockitoAnnotations.initMocks(this);
		
		userDto = new UserDto();
		userDto.setUserName("Jaljala");
		userDto.setPassword("jaljala@321");
		
	}



	@Test
	public void agetAllUserCredentialFromDb() throws Exception {

		List<User> al = new ArrayList<User>();

		User userDto3 = new User(null, "Savita", "Sav@321");

		User userDto4 = new User(null, "Swatantra", "Swa@321");

		al.add(userDto3);
		al.add(userDto4);

		Mockito.when(userService.findAll()).thenReturn(al);
		List<User> result = kafkaController.getAllUserCredentialFromDb();
		// verify(userService,times(1)).findAll();
		assertEquals(2, result.size());

	}

}
