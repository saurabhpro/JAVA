package com.saurabh.hibernate.demo;

import com.saurabh.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session
		Session session;

		try (SessionFactory factory = new Configuration() /*create session factory*/
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			// delete the student
			System.out.println("Deleting student: " + myStudent);
			if (myStudent != null)
				session.delete(myStudent);

			// delete student id=2
			System.out.println("Deleting student id=2");

			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
	}

}





