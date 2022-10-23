package com.hello.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hello.HelloService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

	
	@MockBean
	private HelloService service;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testEcho() {

		URI targetUrl = UriComponentsBuilder.fromUriString("/hello/echo").build().encode().toUri();
		
		String returned = restTemplate.getForObject(targetUrl, String.class);
		
		assertThat(returned).isNotNull();
		assertThat(returned).isEqualTo("Hello app");
	}

}
