package com.demo.webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import com.demo.webclient.dto.UserRequestDto;
import reactor.core.publisher.Mono;


@Service
public class MyService {

	private final WebClient webClient;

	public MyService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:8082/api").build();
	}

	@SuppressWarnings("deprecation")
	public Mono<String> someRestCall22(UserRequestDto name) {
		return ((RequestBodySpec) this.webClient.get().uri("/createUser1", name)).body(BodyInserters.fromObject(name))
						.retrieve().bodyToMono(String.class);
	}


}