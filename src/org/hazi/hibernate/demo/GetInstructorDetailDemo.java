package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//Get the Instructor Detail Object
			int theId=29999;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//Print the Instructor Detail
			
			System.out.println("The Instructor Detials: "+tempInstructorDetail);
			
			//Print the associate Instructor
			
			System.out.println("Printing associated Instructor : "+tempInstructorDetail.getInstructor());
			
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
