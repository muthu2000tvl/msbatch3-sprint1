package com.sl.ms.sprint1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/hi")
	public static String helloWorld() {
		return "Hello World";
	}
}
