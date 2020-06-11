package com.hazi.springCourse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.hazi.springCourse.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required and must be in number format")
	@Min(value=0, message="Value must be greater or equal to zero")
	@Max(value=10, message="Value must be less or equal to 10")
	private Integer freePasses; 
	
	@Pattern(regexp="^[0-9]{6}", message="format should be, 123456")
	@NotNull(message="is required")
	private String postalCode;
	
	@CourseCode(value="TOPS", message="must start with TOPS")
	private String courseCode;
	
	

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	
	
	
	
	
	

}
