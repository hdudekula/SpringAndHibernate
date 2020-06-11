package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//create a student object
			
			System.out.println("Creating a student object...");
			Student tempStudent = new Student("hazi", "D", "hazi.dudekula@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving Student Object...");
			session.save(tempStudent);
			
			//commit a transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		
		finally {
			session.close();
		}

	}

}
