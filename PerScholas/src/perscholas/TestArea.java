package perscholas;
import java.util.Scanner;

public class TestArea {
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("What is your favorite team?");
		String answer = reader.nextLine();
		System.out.println("Go "+ answer +"!");
		reader.close();
		
	}
	

}
