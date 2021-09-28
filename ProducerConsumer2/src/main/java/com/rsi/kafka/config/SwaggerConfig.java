package com.rsi.kafka.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	//Configuring application related endpoints  with  Docket builder
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
				.basePackage("com.rsi.kafka.controller"))
				.paths(regex("/kafka.*")).build()
				.apiInfo(apiInfo());

	}

	//Adding  application  Metadata
	private ApiInfo apiInfo() {
		return new ApiInfo("User Credentials API", 
				"Sample For Kafka Topic", 
				"1.0", 
				"Free to use",
				new springfox.documentation.service.Contact("Ankit Tyagi", "https://start.spring.io/", "tankit4@gmail.com"),
				"API License",
				"https://start.spring.io/",
				Collections.emptyList()

		);

	}

}