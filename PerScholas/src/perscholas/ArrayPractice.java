package perscholas;

public class ArrayPractice {
	
	public static void main(String[] args) {
		//count consonants
		String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String vowels = "aeiou";
		
		String[] lettersArray = letters.split(",");
		int numOfLetters = 0;
		
		for (String letter : lettersArray) {
			if (! vowels.contains(letter)) {
				numOfLetters++;
			}
		}
		System.out.println("Number of letters that aren't vowels: "+ numOfLetters);
		
	}

}
