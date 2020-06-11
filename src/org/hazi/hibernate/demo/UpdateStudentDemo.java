package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int studentId = 1;
			session.beginTransaction();
			
			//Getting the Student ID based on the primary Key
			System.out.println("\nGetting Student with ID" + studentId);

			Student myStudent = session.get(Student.class, studentId);
			
			//Updating the student Id
			System.out.println("Updating Student.class..");
			myStudent.setFirstName("H");
			
			//commit the transaction
			session.getTransaction().commit();
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Updating all student Emails
			
			System.out.println("\n\nUpdating all email addresses..");
			session.createQuery("Update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		
		finally {
			session.close();
		}

	}

}
