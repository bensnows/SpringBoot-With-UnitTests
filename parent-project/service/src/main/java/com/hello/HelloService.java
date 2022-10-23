package com.hello;

import java.util.List;

import com.hello.dto.HelloWorldDto;

public interface HelloService {
	
	
	public void insertSomeThing(HelloWorldDto helloWorldDto);
	
	public List<String> getNames();
}
