package jpa.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class StudentService implements StudentDAO {

	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);

		List<Student> result = query.getResultList();
		session.close();
		
		return result;
	}

	public Student getStudentByEmail(String sEmail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s WHERE s.sEmail = :sEmail";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("sEmail", sEmail);

		try {
			Student result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		} finally {
			session.close();
			
		}

	}

	public boolean validateStudent(String sEmail, String password) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s WHERE s.sEmail = :sEmail AND s.sPass = :sPass";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("sEmail", sEmail);
		query.setParameter("sPass", password);

		try {
			Student result = query.getSingleResult();
			return true;
		} catch (NoResultException nre) {
			return false;
		} finally {
			session.close();
			
		}

	}

	public void registerStudentToCourse(String sEmail, int cId) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Create join table to find where student email and ID both present
		String hql = "FROM StudentCourse sc WHERE sc.student.sEmail = :sEmail AND sc.course.cId = :cId";
		TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
		query.setParameter("sEmail", sEmail);
		query.setParameter("cId", cId);

		try {
			// Checks to see if student already in course
			StudentCourse already = query.getSingleResult();
			System.out.println("Student is already registered to that course");
		} catch (NoResultException nre) {
			// If the student is not registered, creates a new registration
			StudentCourse newReg = new StudentCourse();
			// Set student
			newReg.setStudent(getStudentByEmail(sEmail));
			// Set course
			Course course = session.get(Course.class, cId);
			newReg.setCourse(course);
			// Set sEmail
			newReg.setsEmail(sEmail);

			// Save the new registration
			session.beginTransaction();
			session.save(newReg);
			session.getTransaction().commit();
			System.out.println("Successfully registered");
		} finally {
			session.close();
			
		}
	}

	public List<Course> getStudentCourses(String sEmail) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT c FROM StudentCourse sc, Course c WHERE sc.sEmail = :sEmail AND c.cId = sc.course.cId";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("sEmail", sEmail);

		try {
			List<Course> result = query.getResultList();
			return result;
		} catch (NoResultException nre) {
			return null;
		} finally {
			session.close();
			
		}

	}

}
