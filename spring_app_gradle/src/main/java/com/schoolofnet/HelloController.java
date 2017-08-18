package com.schoolofnet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

	//http://localhost:8080/hello/
	@RequestMapping
	@ResponseBody
	public String hello() {
		return "Hello World by School of net";
	}
	
	@GetMapping(path = "/say/{name}")
	@ResponseBody 
	public String say(@PathVariable String name) {
		return "Hello " + name + " this is my new method";
	}
	
	
	@PostMapping(path = "/say")
	@ResponseBody
	public String sayPost(@RequestParam String name) {
		return "This is my result: " + name;
	}
}
