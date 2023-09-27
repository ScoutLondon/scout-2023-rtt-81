package perscholas;

public class ArrayMinMax {
	
	public static void main(String[] args) {
		
		double[] numbers = {5.5, 4.7, 8.4, 2.2, 7.4, 4.4, 3.5};
		
		//find min and max value of array
		
		double min = numbers[0];
		double max = numbers[0];
		
		for( double number : numbers) {
			if (number<min) {
				min = number;
			}
			if ( number > max) {
				max = number;
			}
		}
		
		System.out.println("min = " + min);
		System.out.println("max = " + max);
		
	}

}
