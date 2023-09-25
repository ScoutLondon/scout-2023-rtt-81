package perscholas;
import java.util.Scanner;

public class PA303_4_1_7 {
	int[][] b = new int[4][6];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your filing status?\n"
				+ "1) Single\n"
				+ "2)Married Filing Jointly or Qualifying Widow(er)\n"
				+ "3) Married Filing Separately\n"
				+ "4) Head of Household");
		int status = scan.nextInt();
		System.out.println("What is your income?");
		int income = scan.nextInt();
		
	}

}
