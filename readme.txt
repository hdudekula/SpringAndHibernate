Steps:
--------------------

1. set up our development environment. 

2. required field

3. validate number range : min and max

4. validate using regular expressions (regexp)

5. Custom validation

Development Process
--------------
1.1 Download a validation JAR files from Hibernate website

1.2 ADD Jars to the project

1.3 Add all Jars from dist folder of Hibernate validation JAR under WEB-INF/lib folder in our project

Coding
---------------------
1. Add Validation rule to customer Class

2. Display error message on HTML form

3. Perform validation in controller classs

4. Update confirmation page


Special Note about BindingResult Parameter Order:
When performing Spring MVC validation, the location of the BindingResult parameter is very important. In the method signature, the BindingResult parameter must appear immediately after the model attribute. 

If you place it in any other location, Spring MVC validation will not work as desired. In fact, your validation rules will be ignored.

In Continuation to form validation:
--------------------------------
--------------------------------
Development Process for ValidatingNumberRange:
------------------------------------------------------

1. Add Validation Rule to Customer Class

2. Display error message on HTML form

3. Perform validation in Controller class

4. Update confirmation Page


How to Handle String in Integer Field:
-------------------------------------------------
-------------------------------------------------

1. Create a Custom Error page
		src/resources/messages.properties
		
2. Load custom messages resource in spring config xml
		WebContent/WEB-INF/spring-mvc-demo-servlet.xml