package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hazi.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//Get the Course and print
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			System.out.println(tempCourse);
			
			//Print the Reviews
			System.out.println(tempCourse.getReviews());
			
			//Deleting the course
			System.out.println("Deleting the course and reviews...");
			session.delete(tempCourse);

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
