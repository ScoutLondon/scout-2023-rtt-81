package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();
	public Student getStudentByEmail();
	public boolean validateStudent();
	public void registerStudentToCourse();
	public List<Course> getStudentCourses();


}
