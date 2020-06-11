//Step2: Creation of StudentController class

package com.hazi.springCourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@RequestMapping("/ShowForm")
	public String showForm(Model theModel) {

		// create a student object

		Student theStudent = new Student();

		// add student object to the model

		theModel.addAttribute("student", theStudent);

		return "Student-Form";
	}

	//step4: Create a form processing data
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// log the input data

		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";
	}

}
