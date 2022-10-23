package com.hello.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;

public class HelloWorldDtoTest {

	private static ObjectMapper mapper;

	@BeforeAll
	public static void beforeAll() {
		mapper = new ObjectMapper();
	}

	@Test
	void testDtoToString() throws JsonProcessingException {

		HelloWorldDto dto = HelloWorldDto.builder().name("Peter").gender(1).build();

		String result = mapper.writeValueAsString(dto);
		assertTrue(StringUtils.contains(result, "\"gender\":1"));
		System.out.println(result);
	}

	@Test
	void testStringToDto() throws JsonProcessingException {
		final String result = "{\"name\":\"Peter\",\"gender\":1}";
		HelloWorldDto dto = mapper.readValue(result, HelloWorldDto.class);

		assertThat(dto.getGender()).isEqualTo(1);
		assertThat(dto.getName()).isEqualTo("Peter");
	}

	@Test
	void testStringToDtoWithException() throws JsonProcessingException {
		final String result = "{\"name\":\"Peter\",\"gender\":3}";

		try {
			mapper.readValue(result, HelloWorldDto.class);
		} catch (ValueInstantiationException e) {
			assertTrue(StringUtils.contains(e.getMessage(), "Gender 無此參數"));
		}
	}
}
