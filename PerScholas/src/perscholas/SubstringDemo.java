package perscholas;

public class SubstringDemo {

	public static void main(String[] args) {
		
		String name = "Scout White";
		
		int spaceAt = name.indexOf(" ");
		String firstname = name.substring(0, spaceAt);
		System.out.println(firstname);
		
		String lastname = name.substring(name.indexOf(" ") + 1);
		System.out.println(lastname);
		
		
		String example = "This is an example";
		
		
		//find position of first space in string
		//find position of last space in string
		//substring of characters between first and last space
		 
		int firstspace = example.indexOf(" ");
		System.out.println("First space at: "+firstspace);
		int lastspace = example.lastIndexOf(" ");
		System.out.println("Last space at: "+lastspace);
		System.out.println(example.substring(firstspace+1, lastspace));
		
		//do the same thing to find substring of first and last vowel of the string
		int firstv=example.length();
		int lastv=-1;
		for (int i = 0; i < example.length(); i++) {
			String test = example.substring(i, i+1);
			if (test.contains("a") || 
					test.contains("e") ||
					test.contains("i") || 
					test.contains("o") || 
					test.contains("u")) {
				if (i< firstv) {
					firstv = i;
				}
				if (i>lastv) {
					lastv = i+1;
				}
			}
		}
		
		System.out.println(example.substring(firstv, lastv));
		
		
		
		
		//use String.charAt function and use a for loop over entire string
		//to print out each character with a new line after it
		//you need to use string.length() function also
		
		for (int i = 0; i < example.length(); i++) {
			System.out.println(example.charAt(i));
		}
	
		//using only indexOf(" ") print substring containing word "is"
		//use 2 substrings to do this
		String is = example.substring(example.indexOf(" ")+1);
		is = is.substring(0, is.indexOf(" "));
		System.out.println(is);

				

	}

}
