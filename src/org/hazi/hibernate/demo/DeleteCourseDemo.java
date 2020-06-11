package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//Get the Course Detail Object
			int theId=10;
			
			Course tempCourse = session.get(Course.class, theId);
			
			//Print the Course Detail
			
			System.out.println("The Course Details: "+tempCourse);
			
			//Delete the course
			System.out.println("Deleting the course "+tempCourse);
			
			//Delete the course
			
			session.delete(tempCourse);
			
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
