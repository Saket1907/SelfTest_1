package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;



public class ArrayListUserDefinedClassTestArrayList {
	public static void main(String args[]){
		
		ArrayListUserDefinedClass UD1 = new ArrayListUserDefinedClass(101, "Saket", 27);
		ArrayListUserDefinedClass UD2 = new ArrayListUserDefinedClass(102, "Prem", 55);
		
		ArrayList<ArrayListUserDefinedClass> AL = new ArrayList<ArrayListUserDefinedClass>();
		AL.add(UD1);
		AL.add(UD2);
		
		Iterator itr = AL.iterator();
		while(itr.hasNext()){
			ArrayListUserDefinedClass UDC = (ArrayListUserDefinedClass)itr.next();
			System.out.println(UDC.roll+" "+UDC.name+" "+UDC.age);
		}
		
	}

}
