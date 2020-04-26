package com.hazi.springCourse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//We add Parent RequestMapping Annotation here to avoid the ambiguity with
//any other controller classes. 
@Controller
@RequestMapping("/hello")
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
	
	//RequestParam annotation is used to bind the data
	@RequestMapping("/processFormVersionThree")
	public String processVersionThree(
			@RequestParam("StudentName") String theName, 
			Model model) {
		
	/*below lines 38 - 41 has been replaced by RequestParam annotation in line 34 */
		/*
		 * //Read the request parameter from a HTML form String theName =
		 * request.getParameter("StudentName");
		 */
	
	//convert the read data to caps
		theName = theName.toUpperCase();
	
	//create a message
		String result = "I am coming from V3! " + theName;
	
	
	//add data to model
		model.addAttribute("message", result);
		
		
		return "Helloworld";
	}
}
