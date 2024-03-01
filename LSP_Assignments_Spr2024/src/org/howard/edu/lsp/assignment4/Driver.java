package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;

public class Driver {
	public class IntegerSetException extends Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1= new ArrayList<>();
		ArrayList<Integer> list2= new ArrayList<>();


		// creating two instances of integerset class to test 
		IntegerSet set1 = new IntegerSet(list1);
		IntegerSet set2 = new IntegerSet(list2);

		list1.add(1);
		list1.add(2);
		list1.add(4);
		list1.add(6);
		list1.add(3);
		list1.add(8);
		list1.add(7);

		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);

		System.out.println("Set 1 : " + set1.get());
		System.out.println("Set 2 : " + set2.get());

		System.out.println("Is Set1 equal to Set2 : " + set1.equals(set2));

		try {
			System.out.println("Largest element in set 1 : " + set1.largest());
		} catch (org.howard.edu.lsp.assignment4.IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Smallest element in set 2 : " + set2.smallest());
		} catch (org.howard.edu.lsp.assignment4.IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IntegerSet seta = set2.union(set1);

		System.out.println("Union : " + seta.get() );

		IntegerSet setb = set2.intersect(set1);

		System.out.println("Intersection : " + setb.get() );



		}

		}
	

{}
}

