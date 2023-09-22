package perscholas;
import java.util.Scanner;

public class PA303_4_1_5 {
	/*Write a program that uses if-else-if statements to 
	 * print out grades A, B, C, D, F, according to the following criteria:
	A: 90-100
	B: 80-89
	C: 70-79
	D: 60-69
	F: <60
	Use the Scanner class to accept a number score from the user to determine 
	the letter grade. Print out “Score out of range” if the score is less than 0 or greater than 100.
	*/
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the grade?");
		int g = scan.nextInt();
		
		if ((g<0)||(g>100)) {
			System.out.println("Score out of range");
		} else if (g>=90) {
			System.out.println("A");
		} else if (g>=80) {
			System.out.println("B");
		} else if (g>=70) {
			System.out.println("C");
		} else if (g>=60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}

}
