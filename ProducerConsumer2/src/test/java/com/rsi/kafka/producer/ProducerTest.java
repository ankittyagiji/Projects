package com.rsi.kafka.producer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.rsi.kafka.ProducerConsumerApplication;
import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.dtovalidation.DtoValidation;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerConsumerApplication.class)
public class ProducerTest {

	@InjectMocks
	Producer producer = new Producer();

	@Mock
	private KafkaTemplate<String, UserDto> kafkaTemp;
	// private DtoValidation dtoValidation = Mockito.mock(DtoValidation.class);

	@Mock
	private DtoValidation dtoValidation;

	@Mock
	UserDto userDto;

	//private static Properties prop;	
	
	@Before
	public void setup() throws IOException {
		MockitoAnnotations.initMocks(this);

		userDto = new UserDto();
		userDto.setUserName("Jaljala");
		userDto.setPassword("jaljala@321");
		
		/*
		 * prop = new Properties();
		 * 
		 * FileInputStream fis = new FileInputStream(
		 * "C:\\MyEclipseWorkspace\\ProducerConsumer\\src\\test\\resources\\application.properties"
		 * );
		 * 
		 * prop.load(fis);
		 */
		  
		 // Producer.jsonTopic = prop.getProperty("kafka.topic.json");
		 
		//System.out.println(Producer.jsonTopic);
		

	}

	@Test
	public void csendUserCredToKafkaTestCase() throws IOException {

		producer.publishToTopic(userDto);

		String jsonTopic=null;
		verify(kafkaTemp, times(1)).send(jsonTopic, userDto);
		System.out.println(jsonTopic);
		 //verify(dtoValidation,times(1)).checkValidations(userDto);
	}

}
