package com.hello.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@Test
	void testInsert() throws Exception {
		URI targetUrl = UriComponentsBuilder.fromUriString("/hello/").build().encode().toUri();

		HttpEntity<String> request = buildRequest();

		ResponseEntity<String> response = restTemplate.postForEntity(targetUrl, request, String.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).isNull();
	}

	private HttpEntity<String> buildRequest() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject personJsonObject = new JSONObject();
		personJsonObject.put("name", "Peter");
		personJsonObject.put("gender", 1);

		HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);

		return request;
	}

}
