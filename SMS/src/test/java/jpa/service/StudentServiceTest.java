package jpa.service;
import org.junit.jupiter.api.*;

import jpa.entitymodels.Student;

public class StudentServiceTest {
	
	@Test
	public void getStudentByEmailTest() {
		StudentService studentService = new StudentService();
		Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");
		Assertions.assertEquals("aiannitti7@is.gd", actual.getsEmail());
		Assertions.assertEquals("Alexandra Iannitti", actual.getsName());
		Assertions.assertEquals("TWP4hf5j", actual.getsPass());
	}
	

}
