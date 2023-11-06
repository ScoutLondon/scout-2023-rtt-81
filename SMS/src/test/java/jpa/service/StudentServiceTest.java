package jpa.service;
import org.junit.jupiter.api.*;

import jpa.entitymodels.Student;

public class StudentServiceTest {
	
	@Test
	public void getStudentByEmailTest() {
		StudentService studentService = new StudentService();		//Allows us to use/test StudentService object/methods
		Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");	//Creates a Student with known values
		Assertions.assertEquals("aiannitti7@is.gd", actual.getsEmail());	//Tests the known values against methods
		Assertions.assertEquals("Alexandra Iannitti", actual.getsName());
		Assertions.assertEquals("TWP4hf5j", actual.getsPass());
	}
	

}
