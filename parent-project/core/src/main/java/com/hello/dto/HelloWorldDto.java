package com.hello.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.hello.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@NotBlank
	private String name;

	@Valid
	@NotBlank
	private Gender gender;

}
