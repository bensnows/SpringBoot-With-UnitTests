package com.hello.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

	Male(1), Female(2);

	@JsonValue
	private final Integer gender;

//	public static Gender parse(Integer gender) {
//
//		for (Gender value : values()) {
//			if (value.gender.equals(gender)) {
//				return value;
//			}
//		}
//		throw new RuntimeException("Parse exception, Gender 無此參數 Gender:"+gender.toString());
//	}

	public String toString() {
		return gender.toString();
	}

}
