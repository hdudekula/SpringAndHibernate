package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hazi.hibernate.demo.entity.Review;
import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesToStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//get a student Chitlu from database
			int studentId=2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student : "+tempStudent);
			System.out.println("\ncourses: "+tempStudent.getCourses());
			
			// commit a transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		}

		finally {
			session.close();
			factory.close();
		}

	}

}
