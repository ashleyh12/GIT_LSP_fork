package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerSetTest {

	public static void main(String[] args) {
		private List<Integer> set = new ArrayList<Integer>();
		 
		​// Clears the internal representation of the set
		public void clear() {};
		 
		// Returns the length of the set
		public int length() {}; // returns the length
		 
		/*
		             * Returns true if the 2 sets are equal, false otherwise;
		* Two sets are equal if they contain all of the same values in ANY order.
		*/
		public boolean equals(IntegerSet b) {…};
		 
		// Returns true if the set contains the value, otherwise false
		public boolean contains(int value) {…};    
		 
		// Returns the largest item in the set; Throws a IntegerSetException if the set is empty
		public int largest() throws IntegerSetException {…};
		 
		// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
		public int smallest() throws IntegerSetException {
			return 0;
		}
		 
//		​// Adds an item to the set or does nothing it already there​.
		
		​public void add(int item) {…}; // adds item to s or does nothing if it is in set 
		 
		​// Removes an item from the set or does nothing if not there
		public void remove(int item) {…};
		 
		// Set union
		public void union(IntegerSet intSetb) {…};
		 
		// Set intersection
		public void intersect(IntegerSet intSetb) {…};
		 
		// Set difference, i.e., s1 –s2
		public void diff(IntegerSet intSetb) {
		} // set difference, i.e., s1 - s2
		 
		// Set complement, all elements not in s1
		public void complement(IntegerSet intSetb) {…};
		 
		// Returns true if the set is empty, false otherwise
		boolean isEmpty() {
			return false;
		}
		 
		// Return String representation of your set
		public String toString() {…};​// return String representation of your set
		}
		// TODO Auto-generated method stub

	}

//IntegerSet class from Assignment 4

	class IntegerSet {
	    private List<Integer> set;
	
	    public IntegerSet() {
	        set = new ArrayList<>();
	    }
	
	    public void clear() {
	        set.clear();
	    }
	
	    public int length() {
	        return set.size();
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        IntegerSet that = (IntegerSet) o;
	        return setEquals(that.set, set);
	    }
	    private boolean setEquals(List<Integer> set2, List<Integer> set3) {
	        return set2.size() == set3.size() && set2.containsAll(set3);
		}

		public boolean contains(int value) {
	        return set.contains(value);
	    }
	
	    public int largest() {
	        if (set.isEmpty()) {
	            throw new IntegerSetException("set is empty");
	        }
	        int max = Integer.MIN_VALUE;
	        for (int num : set) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
	    }
	
	    public int smallest() {
	        if (set.isEmpty()) {
	            throw new IntegerSetException("set is empty");
	        }
	        int min = Integer.MAX_VALUE;
	        for (int num : set) {
	            if (num < min) {
	                min = num;
	            }
	        }
	        return min;
	    }
	
	    public void add(int item) {
	        set.add(item);
	    }
	
	    public void remove(int item) {
	        set.remove((Integer) item);
	    }
	
	    public void union(IntegerSet intSetb) {
	        set.addAll(intSetb.set);
	    }
	
	    public void intersect(IntegerSet intSetb) {
	        set.retainAll(intSetb.set);
	    }
	
	    public void diff(IntegerSet intSetb) {
	        set.removeAll(intSetb.set);
	    }
	
	    public void complement(IntegerSet intSetb) {
	        Set<Integer> complementSet = new HashSet<>(intSetb.set);
	        complementSet.removeAll(set);
	        set = new ArrayList<>(complementSet);
	    }
	
	    public boolean isEmpty() {
	        return set.isEmpty();
	    }
	
	    @Override
	    public String toString() {
	        return set.toString();
	    }
	}
	
	class IntegerSetException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

		public IntegerSetException(String message) {
	        super(message);
	    }
	}
	
