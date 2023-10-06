package perscholas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import shapes.Main;

public class GLAB303_11_2 {
	
	public static void main(String[] args) {
		
		//Example 1: Creating an ArrayList and Adding New Elements
		
		// Creating an ArrayList of String
        List<String> animals = new ArrayList<>();

        // Adding new elements to the ArrayList
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");

        System.out.println(animals);

  // Adding an element at a particular index in an ArrayList
        animals.add(2, "Elephant");
        System.out.println(animals);
        
        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);

        // Creating an ArrayList from another collection
        List<Integer> firstTenPrimeNumbers = new ArrayList<>(firstFivePrimeNumbers);

        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(13);
        nextFivePrimeNumbers.add(17);
        nextFivePrimeNumbers.add(19);
        nextFivePrimeNumbers.add(23);
        nextFivePrimeNumbers.add(29);

        // Adding an entire collection to an ArrayList
        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);

        System.out.println(firstTenPrimeNumbers);
        
        
        //Example 2: Creating an ArrayList From Another Collection
        
        List<Integer> firstFivePrimeNumbers1 = new ArrayList<>();
        firstFivePrimeNumbers1.add(2);
        firstFivePrimeNumbers1.add(3);
        firstFivePrimeNumbers1.add(5);
        firstFivePrimeNumbers1.add(7);
        firstFivePrimeNumbers1.add(11);

        // Creating an ArrayList from another collection
        List<Integer> firstTenPrimeNumbers1 = new ArrayList<>(firstFivePrimeNumbers1);

        List<Integer> nextFivePrimeNumbers1 = new ArrayList<>();
        nextFivePrimeNumbers1.add(13);
        nextFivePrimeNumbers1.add(17);
        nextFivePrimeNumbers1.add(19);
        nextFivePrimeNumbers1.add(23);
        nextFivePrimeNumbers1.add(29);

        // Adding an entire collection to an ArrayList
        firstTenPrimeNumbers1.addAll(nextFivePrimeNumbers1);

        System.out.println(firstTenPrimeNumbers1);
        
        //Example 3: Accessing Elements from an ArrayList
        
        List<String> topCompanies = new ArrayList<>();

        // Check if an ArrayList is empty
        System.out.println("Is the topCompanies list empty? : " + topCompanies.isEmpty());

        topCompanies.add("Google");
        topCompanies.add("Apple");
        topCompanies.add("Microsoft");
        topCompanies.add("Amazon");
        topCompanies.add("Facebook");

        // Find the size of an ArrayList
        System.out.println("Here are the top " + topCompanies.size() + " companies in the world");
        System.out.println(topCompanies);

        // Retrieve the element at a given index

        String bestCompany = topCompanies.get(0);
        String secondBestCompany = topCompanies.get(1);
        String lastCompany = topCompanies.get(topCompanies.size() - 1);

        System.out.println("Best Company: " + bestCompany);
        System.out.println("Second Best Company: " + secondBestCompany);
        System.out.println("Last Company in the list: " + lastCompany);

        // Modify the element at a given index
        topCompanies.set(4, "Walmart");
        System.out.println("Modified top companies list: " + topCompanies);
        
        //Example 4: Removing Elements from an ArrayList
        
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Python");
        programmingLanguages.add("Perl");
        programmingLanguages.add("Ruby");

        System.out.println("Initial List: " + programmingLanguages);

        // Remove the element at index `5`
        programmingLanguages.remove(5);
        System.out.println("After remove(5): " + programmingLanguages);

        // Remove the first occurrence of the given element from the ArrayList
        // (The remove() method returns false if the element does not exist in the ArrayList)
        boolean isRemoved = programmingLanguages.remove("Kotlin");
        System.out.println("After remove(\"Kotlin\"): " + programmingLanguages);

        // Remove all the elements that exist in a given collection
        List<String> scriptingLanguages = new ArrayList<>();
        scriptingLanguages.add("Python");
        scriptingLanguages.add("Ruby");
        scriptingLanguages.add("Perl");

        programmingLanguages.removeAll(scriptingLanguages);
        System.out.println("After removeAll(scriptingLanguages): " + programmingLanguages);

        // Remove all elements from the ArrayList
        programmingLanguages.clear();
        System.out.println("After clear(): " + programmingLanguages);
        
        //Example 5: Iterating over an ArrayList
        
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game Of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");
        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
           String tvShow = tvShowIterator.next();
           System.out.println(tvShow);
        }

   System.out.println("==Iterate using an iterator() and forEachRemaining() method ===");
        tvShowIterator = tvShows.iterator();
        tvShowIterator.forEachRemaining(tvShow -> {
           System.out.println(tvShow);
        });


        System.out.println("\n=== Iterate using simple for-each loop ===");
        for(String tvShow: tvShows) {
           System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for(int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
         }
         System.out.println("\n=== Iterate iterator ===");
         ListIterator iterator = tvShows.listIterator();
         System.out.println("Elements in forward direction");

         System.out.println("\n====== Iterate using while loop=======");

         while (iterator.hasNext())
         {
            System.out.println(iterator.next());
         }

         System.out.println("=========Elements in backward direction======");

         while (iterator.hasPrevious())
         {
            System.out.println(iterator.previous());
         }
         
         //Example 6: Searching for Elements in an ArrayList
         
         List<String> names = new ArrayList<>();
         names.add("John");
         names.add("Alice");
         names.add("Bob");
         names.add("Steve");
         names.add("John");
         names.add("Steve");
         names.add("Maria");

       // Check if an ArrayList contains a given element
         System.out.println("Does names array contain \"Bob\"? : " + names.contains("Bob"));

       // Find the index of the first occurrence of an element in an ArrayList
         System.out.println("indexOf \"Steve\": " + names.indexOf("Steve"));
         System.out.println("indexOf \"Mark\": " + names.indexOf("Mark"));

       // Find the index of the last occurrence of an element in an ArrayList
         System.out.println("lastIndexOf \"John\" : " + names.lastIndexOf("John"));
         System.out.println("lastIndexOf \"Bill\" : " + names.lastIndexOf("Bill"));



		
	}

}
