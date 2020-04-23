Create a Dynamic Web Project

Copy all the SPring Jar files under lib folder in WebContent/WEB-INF/lib

create web.xml and spring-mvc-demo-servlet.xml files. 

as mentioned in spring-mvc-demo-servlet.xml, we need a folder called view under WEB-INF. so, create it. 


Steps to create first MVC Class:
------------------------------------
1. Create a Controller class. (HomeController.java)
2.Define a controller method (@Controller)
3.Add Request Mapping to controller method (@RequestMapping("/")
4.Return a View name ("main-menu")
5.Develop a view page