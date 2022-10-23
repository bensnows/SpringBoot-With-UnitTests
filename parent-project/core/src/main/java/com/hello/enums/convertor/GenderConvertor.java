package com.hello.enums.convertor;

import org.springframework.core.convert.converter.Converter;

import com.hello.enums.Gender;

public class GenderConvertor implements Converter<Integer, Gender>{

	    @Override
	    public Gender convert(Integer gender) {
	    	
	    	
	    	for (Gender value : Gender.values()) {
				if(gender.equals(value.getGender())) {
					return value;
				}
			}
			throw new RuntimeException("Gender convert exception");

	    }

}
