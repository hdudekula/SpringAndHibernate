package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
			
			//Demo of HQL
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " +
			"JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);
			
			//set the parameters
			query.setParameter("theInstructorId", theId);
			
			//execute the query
			Instructor tempInstructor = query.getSingleResult();
			
			//Print the Instructor Detail
			
			System.out.println("The Instructor: "+tempInstructor);
			
			//commit a transaction
			session.getTransaction().commit();
			
			session.close();
			
			//Print the associate Courses
			
			System.out.println("Courses : "+tempInstructor.getCourses());
			
			System.out.println("Done!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
		}

	}

}
