package com.saurabh.hibernate.demo;

import com.saurabh.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * HSQL uses java classes and properties to be used in query
 */

public class HSQLQueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			//no point in adding the <Student> as the result of list() will be Object
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);

			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);

			// query students: lastName='Doe' OR firstName='Daffy'
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
			displayStudents(theStudents);

			// query students where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%luv2code.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with luv2code.com");
			displayStudents(theStudents);


			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}





