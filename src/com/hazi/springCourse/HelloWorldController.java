package com.hazi.springCourse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	//Need a controller method to read form data and
	//add data to model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
	
	//Read the request parameter from a HTML form
		String theName = request.getParameter("StudentName");
	
	//convert the read data to caps
		theName = theName.toUpperCase();
	
	//create a message
		String result = "Yo! " + theName;
	
	
	//add data to model
		model.addAttribute("message", result);
		
		
		return "Helloworld";
	}
}
