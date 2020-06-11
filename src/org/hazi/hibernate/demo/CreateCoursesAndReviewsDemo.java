package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hazi.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//Create a course
			Course tempCourse = new Course("Astrophysics - for young people");
			
			//Create a Review
			
			tempCourse.addReview(new Review("Great Course, Loved it"));
			tempCourse.addReview(new Review("Great stuff"));
			tempCourse.addReview(new Review("You are really a personal astrophysicist"));
			
			//Save Course and reviews using cascade All
			System.out.println("Saving Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);


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
