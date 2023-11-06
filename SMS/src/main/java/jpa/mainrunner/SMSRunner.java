package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;



public class SMSRunner{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Hi!  Welcome to the Student Management System.");
		System.out.println("Select from the following options: ");
		System.out.println("1. Student portal");
		System.out.println("2. Quit");
		int launch = scan.nextInt();
		scan.nextLine();
		if (launch != 1) {
			System.out.println("We hope to see you next semester!");
		} else {
		System.out.println("Enter your email:");
		String email = scan.nextLine();
		System.out.println("Enter your password:");
		String password = scan.nextLine();
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		if (! (studentService.validateStudent(email, password))){
			System.out.println("Invalid student credentials!");
			System.exit(1);
		} else {
			
			System.out.println("My courses:");
			List<Course> myCourses = studentService.getStudentCourses(email);
			
			for (Course course : myCourses) {
				System.out.println(course.getcId() + "     " + course.getcName());
			}
			
			System.out.println("Select from options: ");
			System.out.println("1. Register to course");
			System.out.println("2. Quit");
			int regOrQuit = scan.nextInt();
			if (regOrQuit != 1) {
				System.out.println("We hope you register next semester!");
				System.exit(1);
			} else {
				System.out.println("Available Courses: ");
				List<Course> availableCourses = courseService.getAllCourses();
				
				for (Course course : availableCourses) {
					System.out.println(course.getcId() + "     " + course.getcName());
				}
				System.out.println("Select course by ID: ");
				int courseSelect = scan.nextInt();
				studentService.registerStudentToCourse(email, courseSelect);
				System.out.println("My updated courses: ");
				
				List<Course> myCoursesUpdate = studentService.getStudentCourses(email);
				for (Course course : myCoursesUpdate) {
					System.out.println(course.getcId() + "     " + course.getcName());
				}
				
				System.out.println("We look forward to seeing you next semester!");
				System.exit(1);
			}
			
		}
			
		}
		
	}

}
