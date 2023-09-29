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
			System.out.println(Calculator.plus(a,b));
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
