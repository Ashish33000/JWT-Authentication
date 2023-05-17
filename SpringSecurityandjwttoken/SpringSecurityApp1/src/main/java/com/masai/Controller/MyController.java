package com.masai.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to Spring Security";
	}
	
	//protected
	@GetMapping("/hello2")
	public String sayHello2() {
		return "Welcome to Spring Security-2";
	}
	
	@GetMapping("/hello3")
	public String sayHello3() {
		return "Welcome to Spring Security-3";
	}

}
