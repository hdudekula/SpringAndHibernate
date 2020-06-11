package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create a student object
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Mastanbee", "D", "bc@gmail.com");
			Student tempStudent2 = new Student("Gouse", "Dudekula", "gd@gmail.com");
			Student tempStudent3 = new Student("Nalini", "D", "ND@gmail.com");
			
			
			//start a transaction
			
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving the objects to DB...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			
			//commit the student object
			
			session.getTransaction().commit();
			System.out.println("DONE!");
			
			
		}
		finally {
			session.close();
		}

	}

}
