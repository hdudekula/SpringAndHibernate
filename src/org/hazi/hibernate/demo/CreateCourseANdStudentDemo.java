package org.hazi.hibernate.demo;

import org.hazi.hibernate.demo.entity.Course;
import org.hazi.hibernate.demo.entity.Instructor;
import org.hazi.hibernate.demo.entity.InstructorDetail;
import org.hazi.hibernate.demo.entity.Review;
import org.hazi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseANdStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//Create a course
			Course tempCourse = new Course("Astrophysics - for young people");
			
			//Saving the session
			System.out.println("Saving the studen course.. ");
			session.save(tempCourse);
			System.out.println("Saved the student course.."+tempCourse);

			//create a student
			Student tempStudent1 = new Student("chitlu", "jaishna", "chitlu@easycoding.com");
			Student tempStudent2 = new Student ("eeshu", "surag", "eeshu@easycoding.com");
			
			//add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("Saving the students..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved students:"+tempCourse.getStudents());
			
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
