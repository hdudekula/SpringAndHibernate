package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			/*
			 * //Create Objects 
			 * Instructor tempInstructor = new Instructor("Hazi",
			 * "Dudekula", "hazi.dudekula@easycoding.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://easycoding.com/youtube", "Amateur astronaut");
			 */
			
			Instructor tempInstructor = new Instructor("Bandana",
					  "C", "Bandana.c@easycoding.com");
			
			InstructorDetail tempInstructorDetail = new
					  InstructorDetail("http://easycoding.com/youtube", "Pubg");
			//associate objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//Save objects to the database
			
			//NOTE: This will also save into Instructor_detail table along with instructor table
			//because we used CASCADE.ALL
			System.out.println("Saving into Instructor Table "+tempInstructor);
			session.save(tempInstructor);
			
			//commit a transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		
		finally {
			session.close();
		}

	}

}
