package perscholas;

import java.util.Arrays;

public class GLAB303_3_1_7 {
	
	public static void main(String[] args) {
	    String vowels = "a::b::c::d:e";

	    // splitting the string at "::"
	    // storing the result in an array of strings
	    String[] result = vowels.split("::");

	    // converting array to string and printing it
	    System.out.println("result = " + Arrays.toString(result));
	    
	    String csv = "a,b,c,d,e,f,g,h,i,j,k";
	    String[] comma = csv.split(",");
	    
	    System.out.println("Result: "+ Arrays.toString(comma));
	    
	  }

}
