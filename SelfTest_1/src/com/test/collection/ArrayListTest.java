package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author saku.isaket
 * 
 * arraylist addition of element
 *
 */

public class ArrayListTest {
	public static void main(String args[]) {
		ArrayList<String> AL = new ArrayList<String>();
		AL.add("Saket");
		AL.add("Siddhartha");
		AL.add("Suman");
		AL.add("Prem");
		AL.add("Puja");
		
		System.out.println(AL);  //print the arraylist in form of array.
		System.out.println("<               ---------------------------               >");
		
		/**
		 * used iterator for printing the arraylist 
		 */
		
		
		Iterator itr = AL.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println("<               ---------------------------               >");
		
		for(String obj:AL)
			System.out.println(obj);

	}
}
