package com.hello.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.HelloService;
import com.hello.dto.HelloWorldDto;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/echo")
	public String echoHello() {
		return "Hello app";
	}

	@PostMapping
	public void insert(@RequestBody @Valid HelloWorldDto helloWorldDto) {
		helloService.insertSomeThing(helloWorldDto);
	}

	@GetMapping("/names")
	public List<String> getNames() {
		return helloService.getNames();
	}

}
