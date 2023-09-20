package com.perscholas.java_basics;

public class CoreJavaVariables {
	
	public static void main(String[] args) {
		
		/*Write a program that declares two integer variables, 
		 * assigns an integer to each, and adds them together. 
		 * Assign the sum to a variable. Print out the result.
		 */
		
		int a = 1;
		int b = 2;
		int c = a + b;
		
		System.out.println(c);
		
		/*Write a program that declares two double variables, 
		 * assigns a number to each, and adds them together. 
		 * Assign the sum to a variable. Print out the result.
		 */
		
		double d = 1.0;
		double e = 2.0;
		double f = d + e;
		
		System.out.println(f);
		
		/*Write a program that declares an integer variable and a 
		 * double variable, assigns numbers to each, and adds them 
		 * together. Assign the sum to a variable. Print out the 
		 * result. What variable type must the sum be?
		 */
		
		int g = 1;
		double h = 2.0;
		double i = g + h;
		
		System.out.println(i);
		
		/*Write a program that declares two integer variables, 
		 * assigns an integer to each, and divides the larger 
		 * number by the smaller number. Assign the result to a 
		 * variable. Print out the result. Now change the larger 
		 * number to a decimal. What happens? What corrections are needed?
		 */
		
		int j = 10;
		int k = 2;
		int l = j/k;
		System.out.println(l);
		
		/*Write a program that declares two double variables, assigns a 
		 * number to each, and divides the larger by the smaller number. 
		 * Assign the result to a variable. Print out the result. Now, cast 
		 * the result to an integer. Print out the result again.
		 */
		
		double m = 10.0;
		double n = 2.0;
		double o = m/n;
		System.out.println(o);
		int p = (int) o;
		System.out.println(p);
		
		/* Write a program that declares two integer variables, x and y, 
		 * and assigns the number 5 to x and the number 6 to y. Declare a 
		 * variable q and assign y/x to it and print q. Now, cast y to a 
		 * double and assign it to q. Print q again.
		 */
		
		int xx = 5;
		int yy = 6;
		double q = yy/xx;
		System.out.println(q);
		q = (double) yy;
		System.out.println(q);
		
		/*Write a program that declares a named constant and uses it 
		 * in a calculation. Print the result.
		 */
		
		final int two = 2;
		System.out.println(two+two);
		
		/*Write a program where you create three variables that represent 
		 * products at a cafe. The products could be beverages like coffee, 
		 * cappuccino, espresso, green tea, etc. Assign prices to each product. 
		 * Create two more variables called subtotal and totalSale and complete 
		 * an “order” for three items of the first product, four items of the 
		 * second product, and two items of the third product. Add them all 
		 * together to calculate the subtotal. Create a constant called SALES_TAX 
		 * and add sales tax to the subtotal to obtain the totalSale amount. 
		 * Be sure to format the results to two decimal places.
		 */
		
		double coke = 1.0;
		double sprite = 1.0;
		double shake = 3.0;
		double subtotal;
		double totalSale;
		final double SALES_TAX = 0.07;
		
		subtotal = (3*coke)+(4*sprite)+(2*shake);
		totalSale = subtotal += (subtotal*SALES_TAX);
		System.out.println(totalSale);
		
		
		
	}

}
