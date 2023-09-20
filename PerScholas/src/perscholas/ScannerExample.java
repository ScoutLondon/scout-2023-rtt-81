package perscholas;
import java.util.Scanner;


public class ScannerExample {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your favorite team?");
		String x = input.nextLine();
		System.out.println("Go " + x + "!");
		input.close();
	}
	
}
