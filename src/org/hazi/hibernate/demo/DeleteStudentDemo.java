package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			session.beginTransaction();

			// Getting the Student ID based on the primary Key
			System.out.println("\nGetting Student with ID" + studentId);

			//Student myStudent = session.get(Student.class, studentId);

			// Updating the student Id
			//System.out.println("Deleting Student ID=1..");
			//session.delete(myStudent);

			// commit the transaction
			//session.getTransaction().commit();

			// NEW CODE

			//session = factory.getCurrentSession();
			//session.beginTransaction();

			//This is an alternatie way of delete using HQL
			// Delete student with ID=2

			System.out.println("\n\nDeleting Student with ID=2..");
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction 
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			session.close();
		}

	}

}
