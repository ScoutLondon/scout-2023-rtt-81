package perscholas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PA303_7_1 {
	
	public static void main(String[] args) {
		
		/*Task 1: Write a program that creates an array of integers 
		 * with a length of 3. Assign the values 1, 2, and 3 to the 
		 * indexes. Print out each array element.
		 */
		
		int[] task1 = new int[] {1,2,3};
		for (int x : task1) {
			System.out.println(x);
		}
		
		System.out.println("*************");
		/*Task 2: Write a program that returns the middle element in an array. 
		 * Give the following values to the integer array: {13, 5, 7, 68, 2} 
		 * and produce the following output: 7
		 */
		
		int[] task2 = new int[] {13, 5, 7, 68, 2};
		int middleElement = (task2.length/2);
		System.out.println(task2[middleElement]);
		
		System.out.println("****************************");
		
		/*Task 3: Write a program that creates an array of String type and initializes 
		 * it with the strings “red,” “green,” “blue,” and “yellow.” Print out the array 
		 * length. Make a copy using the clone( ) method. Use the Arrays.toString( ) 
		 * method on the new array to verify that the original array was copied.
		 */
		
		String[] task3 = new String[] {"red","green","blue","yellow"};
		System.out.println("Array length: "+task3.length);
		String[] clone3 = task3.clone();
		System.out.println(Arrays.toString(clone3));
		
		System.out.println("********************");
		
		/*Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers). 
		 * The numbers can be any integers.  Print out the value at the first index and the 
		 * last index using length - 1 as the index. Now try printing the value at index = length 
		 * (e.g., myArray[myArray.length] ).  Notice the type of exception which is produced. 
		 * Now try to assign a value to the array index 5. You should get the same type of exception.
		 */
		
		int[] task4 = new int[] {0,1,2,3,4};
		System.out.println("First index value: "+ task4[0]);
		System.out.println("Last index value: "+ task4[task4.length-1]);
		//returns arrayindexoutofboundsexception
		System.out.println("******************");
		
		/*Task 5: Write a program where you create an integer array with a length of 5. 
		 * Loop through the array and assign the value of the loop control variable (e.g., i) 
		 * to the corresponding index in the array.
		 */
		
		int[] task5 = new int[5];
		for (int i = 0; i < task5.length; i++) {
			task5[i]=i;
		}
		System.out.println(Arrays.toString(task5));
		
		System.out.println("*********************");
		
		/*Task 6: Write a program where you create an integer array of 5 numbers. Loop through 
		 * the array and assign the value of the loop control variable multiplied by 2 to the 
		 * corresponding index in the array.
		 */
		
		int[] task6 = new int[5];
		for (int i = 0; i<task6.length; i++) {
			task6[i]= i*2;
		}
		System.out.println(Arrays.toString(task6));
		
		System.out.println("********************");
		
		/*Task 7: Write a program where you create an array of 5 elements. Loop through the array 
		 * and print the value of each element, except for the middle (index 2) element.
		 */
		
		int[] task7 = new int[] {0,1,2,3,4};
		for (int i = 0; i< task7.length; i++) {
			if (i != 2) {
				System.out.println(task7[i]);
				
			}
		}
		
		System.out.println("******************");
		
		/*Task 8: Write a program that creates a String array of 5 elements and swaps the first 
		 * element with the middle element without creating a new array.
		 */
		
		String[] task8 = new String[] {"red", "blue", "green", "yellow", "pink"};
		System.out.println(Arrays.toString(task8));
		String sub0= task8[0];
		String sub2= task8[2];
		task8[0]=sub2;
		task8[2]=sub0;
		System.out.println(Arrays.toString(task8));
		
		System.out.println("******************");
		
		
		/*Task 10: Create an array that includes an integer, 3 strings, 
		 * and 1 double. Print the array.
		 */
		
		Object[] objectArray = new Object[5];
		objectArray[0] = Integer.valueOf(4);
		objectArray[1] = "String 1";
		objectArray[2] = "String 2";
		objectArray[3] = "String 3";
		objectArray[4] = 1.0;
		
		System.out.println(Arrays.toString(objectArray));
		System.out.println("*************************");

		
		
		
		/*Task 11: Write some Java code that asks the user how many favorite things 
		 * they have. Based on their answer, you should create a String array of 
		 * the correct size. Then ask the user to enter the things and store them 
		 * in the array you created. Finally, print out the contents of the array.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many favorite things?");
		int numFavorites = scan.nextInt();
		scan.nextLine();
		//nextLine is required because nextInt won't advance to next line
		//subtle but also will wreck code without
		
		String[] favorites = new String[numFavorites];
		
		for ( int pos = 0; pos < numFavorites; pos++) {
			System.out.println("Enter favorite thing # "+ pos);
			favorites[pos] = scan.nextLine();
		}
		
		System.out.println(Arrays.toString(favorites));
		

	}

}
