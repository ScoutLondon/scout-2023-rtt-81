package perscholas;

public class ConditionalOperators {
	
	public static void main(String[] args) {
		
		boolean cold = true;
		boolean cloudy = false;
		
		if (cold || cloudy) {
			System.out.println("It is either cold or cloudy.");
		}
		
		if (cold && cloudy) {
			System.out.println("It is both cold and cloudy.");
		}
		
		int x = 77;
		
		if (x > 0 && x < 100) {
			System.out.println("X is bigger than zero but smaller than 100");
		}
		
		if (x%2 == 1) {
			System.out.println("X is odd");
		} else {
			System.out.println("X is even");
		}
	}

}
