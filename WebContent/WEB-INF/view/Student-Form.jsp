
<!-- Step3: Create a HTML form -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Page</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName" />
		
	<br><br>
	
	Last Name: <form:input path="lastName"/>
		
	<br><br>
	
	Country:
	
	<form:select path="Country">
	
	<!-- Below lines 31 - 33 are commented to read contries list from Student Class -->
		<%-- <form:option value="India" label="India"/>
		<form:option value="Canada" label="Canada"/>
		<form:option value="USA" label="USA"/> --%>
		
		<form:options items="${student.countryOptions}"/>
		
	</form:select>
	<br><br>
	
	Favorite Language:
	
	Java  <form:radiobutton path="favoriteLanguage" value="Java"/>
	C#  <form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	
	<br><br>
	
	Operating System:
	
	Window <form:checkbox path="operatingSystem" value="Windows"/>
	Linux <form:checkbox path="operatingSystem" value="Linux"/>
	Ubuntu <form:checkbox path="operatingSystem" value="Ubuntu"/>
	
	<br><br>
	
	<input type="submit" value="submit">
		


	</form:form>

</body>
</html>