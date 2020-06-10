package com.hazi.springCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	//Need a controller method to show the initial HTML form 
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "Helloworld-form";
	}
	
	//Need a controller method to process form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "Helloworld";
	}
	
	
}
