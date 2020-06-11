package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//create a student object
			
			System.out.println("Creating a student object...");
			Student tempStudent = new Student("bandana", "c", "bc@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving Student Object...");
			System.out.println("Getting a saved object  "+tempStudent.getId());
			session.save(tempStudent);
			
			//commit a transaction
			session.getTransaction().commit();
			
			//*********We are writing code here to Read from Database************//
			//create a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the ID...
			System.out.println("Getting student with ID "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		
		finally {
			session.close();
		}

	}

}
