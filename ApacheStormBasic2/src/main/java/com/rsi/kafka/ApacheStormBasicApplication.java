package com.rsi.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ApacheStormBasicApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApacheStormBasicApplication.class, args);
		
				//ConfigurableApplicationContext context = SpringApplication.run(ApacheStormBasicApplication.class, args);
				//ReviewTopology app = context.getBean(ReviewTopology.class);
				//app.runStorm(args);	
	}

}
