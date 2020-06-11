package org.hazi.hibernate.demo;

import java.util.List;

import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			// query the student with last name: Dudekula
			theStudents = session.createQuery("from Student s where s.lastName='Dudekula'").getResultList();

			// dispaly the student with last name:Dudekula
			System.out.println("\n\n Displaying the student with last Name Dudekula");
			displayStudents(theStudents);

			// query student with last Name: Dudekula or firstName: Nalini
			theStudents = session.createQuery("from Student s where s.lastName='Dudekula' OR s.firstName='Nalini'")
					.getResultList();
			System.out.println("\n\n Displaying the student with last Name:Dudekula or firstname with Nalini");
			displayStudents(theStudents);
			
			
			//query students with email like '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			displayStudents(theStudents);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			session.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student thetempStudent : theStudents) {
			System.out.println(thetempStudent);
		}
	}

}
