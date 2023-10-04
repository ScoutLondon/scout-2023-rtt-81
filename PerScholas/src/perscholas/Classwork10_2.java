package perscholas;

public class Classwork10_2 {
	
	public static void main(String[] args) {
		
		/*1. write a for loop that calculates the sum of all 
		 * the numbers between 1 and 100
		 */
		int sum1 = 0;
		for (int i = 1; i <= 100; i++) {
			sum1+=i;
		}
		System.out.println("Sum of #'s between 1 and 100: "+sum1);
		
		
		/*2. write a for loop that calculates the sum of the 
		 * remainders of each number divided by 2 between 1 and 100
		 */
		
		int sum2 = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum2= sum2 + i%2;
			//sum2 += i%2;
		}
		System.out.println("Sum of remainders for 1-100 div by 2: "+ sum2);
		
		
		/*3.  write a for loop that calculates the sum of the 
		 * divisor of each number divided by 2 between 1 and 100
		 */
		
		int sum3 = 0;
		
		for (int i=1; i <= 100; i++) {
			sum3+= i/2;
		}
		System.out.println("Sum of divisors for 1-100 div by 2: "+ sum3);
		
		/*write a while loop ...  while a number is greater than 0 
		 * subtract 1 from the number starting at 10.
		 */
		int x = 10;
		while (x > 0) {
			x--;
		}
		System.out.println("Final number is: "+ x);
	}

}
