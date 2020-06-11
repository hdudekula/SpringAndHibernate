package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//Get the Instructor Object
			int theId=1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//Print the Instructor Detail
			
			System.out.println("The Instructor: "+tempInstructor);
			
			//Print the associate Courses
			
			System.out.println("Courses : "+tempInstructor.getCourses());
			
			//commit a transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
		}

	}

}
