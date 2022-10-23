package com.hello.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@NotBlank
	private String name;

	@NotNull
	@Min(1)
	@Max(2)
	private Integer gender;

}
