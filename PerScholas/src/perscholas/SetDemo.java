package perscholas;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	
	public static void main(String[] args) {
		
		Set<String> stringSet = new HashSet<>();
		
		stringSet.add("a");
		stringSet.add("b");
		stringSet.add("c");
		stringSet.add("a");
		
		for (String string : stringSet) {
			System.out.println(string);
		}
		
		
		
		
	}
	
	

}
