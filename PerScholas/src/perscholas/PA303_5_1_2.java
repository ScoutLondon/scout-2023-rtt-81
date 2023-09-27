package perscholas;

import java.util.Scanner;

public class PA303_5_1_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n1 = readNum(scan);
		int n2 = readNum(scan);
		
		System.out.println("First number: " + n1);
		System.out.println("Second number: " + n2);
		
		
		int gcd=1;
		int min = Math.min(n1, n2);
		
		for (int k = 1; k<= min; k++) {
			if((n1%k==0)&&(n2%k==0)) {
				gcd = k;
			}
		}
		
		System.out.println("GCD of "+n1+" and "+ n2 + " is "+ gcd);
	
	}
		
		//****************************************************
	public static int readNum(Scanner scan) {

		int num = -1;
		while (num <= 0) {
			System.out.println("Enter a positive int greater than 0");
			num = scan.nextInt();

			if (num <= 0) {
				System.out.println("Must be a positive number");
			}
		}

		return num;
		
	

	}

}
