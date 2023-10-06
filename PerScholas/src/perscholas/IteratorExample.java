package perscholas;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
	
	public static void main(String[] args) {
		
		ArrayList<String> strings = new ArrayList<>();
		
		strings.add("one");
		strings.add("two");
		strings.add("three");
		
		for(String string: strings) {
			System.out.println(string);
		}
		
		Iterator <String> itr = strings.iterator();
		while (itr.hasNext()) {
			String string = (String)itr.next();
			System.out.println(string);
		}
		
	}
	

}
