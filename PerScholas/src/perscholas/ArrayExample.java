package perscholas;

public class ArrayExample {
	
	public static void main(String[] args) {
		int arraySize = 10;
		
		double[] doubleArray = new double[arraySize];
		
		String[] stringArray = new String[arraySize];
		stringArray[0]= "zero";
		stringArray[1]= "one";
		stringArray[2]= "two";
		stringArray[9]= "nine";
		
		for (int pos = 0; pos < stringArray.length; pos++) {
			System.out.println("The value in position " + pos + " equals " + stringArray[pos]);
		}
		
		System.out.println("****************************");
		
		for (String x : stringArray) {
			System.out.println("Value : " + x);
		}
		
		int n = 0;
		
		for (String x : stringArray) {
			if (x == null) {
				n++;
			}
		}
		
		System.out.println("Number of nulls: "+ n);
		
		int firstNull = -1;
		for (int pos = 0; pos < stringArray.length; pos++) {
			if (stringArray[pos] == null) {
				firstNull = pos;
				break;
			}
		}
		
		System.out.println("First null is at "+ firstNull);
	}

}
