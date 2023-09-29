package perscholas;

public class StringBufferExample {
	public static void main(String[] args) {
		
		// change x to be abc123xyz
		String x = "abcxyz";
		System.out.println(x);
		x = x.substring(0, 3) + "123" + x.substring(3);
		System.out.println(x);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc").append("xyz");
		buffer.reverse();
		
		buffer.insert(3, "123");
		
		buffer.delete(3, 6);
		
		//replace some characters in string buffer
		StringBuffer sT = new StringBuffer("Java");
		sT.replace(0, 2, "Hello"); //replaces "Ja" with "Hello
		System.out.println(sT);
		

	}
}
