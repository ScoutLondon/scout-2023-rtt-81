package perscholas;


	import java.util.ArrayList;
	import java.util.Iterator;

	public class GLAB303_11_3_AddDataToArrayList {
	  public  ArrayList<GLAB303_11_3_Book> bookdetails() {
	      //User-defined class objects in Java ArrayList
	    
	     ArrayList<GLAB303_11_3_Book> list = new ArrayList<GLAB303_11_3_Book>();
	     // Passing data using Constructors
	     GLAB303_11_3_Book b1 = new  GLAB303_11_3_Book(1, "Death note", "John", "cartoon");
	     GLAB303_11_3_Book b2 = new GLAB303_11_3_Book(2, "Stranger Things", "brothers", "suspense");
	     GLAB303_11_3_Book b3 = new GLAB303_11_3_Book(3, "Spider man", "Alex", "Kids");
	     GLAB303_11_3_Book b4 = new GLAB303_11_3_Book(4, "GentleMen", "Max", "Action");
	      // Passing data using setter
	     GLAB303_11_3_Book b5 = new GLAB303_11_3_Book();
	      b5.setNumber(5);
	      b5.setName("Java FullStack");
	      b5.setAuthor("Flex");
	      b5.setCategory("Programming");
	     // Adding Books objects to Arraylist
	     list.add(b1);
	     list.add(b2);
	     list.add(b3);
	     list.add(b4);
	     list.add(b5);
	     return list;
	   }
	}


