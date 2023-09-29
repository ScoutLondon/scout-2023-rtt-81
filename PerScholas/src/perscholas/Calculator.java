package perscholas;

import java.util.Scanner;

public class Calculator {
	
	
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.menu();
	}
	
	public void menu() {
		System.out.println("What is your number?");
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		scan.nextLine();
		System.out.println("What is your second number?");
		double b = scan.nextDouble();
		scan.nextLine();
		System.out.println("Do you want to + - / or * ?");
		String math = scan.nextLine();
		if (math.equals("+")){
			double x = plus(a,b);
			System.out.println(x);
		} else if (math.equals("-")) {
			double x = minus(a,b);
			System.out.println(x);
		} else if (math.equals("/")) {
			double x = divby(a,b);
			System.out.println(x);
		} else if (math.equals("*")) {
			double x = times(a,b);
			System.out.println(x);
		} else {
			System.out.println("You messed up somewhere, try again");
		}
	}
	
	public double minus(double a, double b) {
		return a-b;
	}
	
	public double plus(double a, double b) {
		return a+b;
	}
	
	public double times(double a, double b) {
		return a*b;
	}
	
	public double divby(double a, double b) {
		return a/b;
	}

}
