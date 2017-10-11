package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Array {


	public static void main(String[] args) {
		
		ArrayList arrayListOne;
		
		arrayListOne = new ArrayList();
		
		ArrayList arrayListTwo;
		
		arrayListTwo = new ArrayList();
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Adam");
		names.add("Frank");
		names.add("West");
		names.add(2,"Ryan");
		names.set(0,"Kaya");
		
		for(int i = 0; i < names.size();i++){
			
			System.out.println(names.get(i));
			
		}
		
		names.remove(3);
		System.out.println(names);
		
		System.out.println("\nAffichage\n");
		
		for(String i : names){
			
			System.out.println(i);
			
		}
		

		// Before the enhanced for you had to use an iterator

		// to print out values in an ArrayList
		// Creates an iterator object with methods that allow
		// you to iterate through the values in the ArrayList

		Iterator indivItems = names.iterator();
		// When hasNext is called it returns true or false
		// depending on whether there are more items in the list
		
		while(indivItems.hasNext())
		
		{
			
			// next retrieves the next item in the ArrayList
			System.out.println(indivItems.next());
			
		}
		
		System.out.println("\nAffichage2\n");
		
		// I create an ArrayList without stating the type of values
		// it contains (Default is Object)
		
		ArrayList nameCopy = new ArrayList();
		ArrayList nameBackup = new ArrayList();
		
		// addAll adds everything in one ArrayList to another
		
		nameCopy.addAll(names);
		System.out.println(nameCopy);
		
		String paulYoung = "Paul Young";
		
		// You can add variable values to an ArrayList
		
		names.add(paulYoung);
		// contains returns a boolean value based off of whether
		// the ArrayList contains the specified object
		
		System.out.println("\nAffichage3\n");
		
		if(names.contains(paulYoung))
		
		{
			System.out.println("Paul is here");
			
		}
		
		// containsAll checks if everything in one ArrayList is in
		// another ArrayList
		
		if(names.containsAll(nameCopy))
		
		{
			
			System.out.println("Everything in nameCopy is in names");
			
		}
		
		// Clear deletes everything in the ArrayList
		
		names.clear();
		
		// isEmpty returns a boolean value based on if the ArrayList
		// is empty
		
		System.out.println("\nAffichage4\n");
		
		if (names.isEmpty())
		
		{
			System.out.println("The ArrayList is empty");
			
		}
		
		Object[] moreNames = new Object[4];
		
		// toArray converts the ArrayList into an array of objects
		
		moreNames = nameCopy.toArray();
		
		// toString converts items in the array into a String
		
		System.out.println(Arrays.toString(moreNames));

		 
		

	}

}
