package org.howard.edu.lsp.assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOException;

public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set;

    // Default Constructor
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    // Constructor with ArrayList parameter
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }
    
    
    
//		​// Clears the internal representation of the set
		public void clear() {
			
			
		};
		 
		// Returns the length of the set
		public int length() {
			
			
		}; // returns the length
		 
		/*
		             * Returns true if the 2 sets are equal, false otherwise;
		* Two sets are equal if they contain all of the same values in ANY order.  This overrides
		* the equal method from the Object class.
		*/
		public boolean equals(Object o) {
			
			
		};
		 
		// Returns true if the set contains the value, otherwise false
		public boolean contains(int value) {
			
			
		};    
		 
		// Returns the largest item in the set; Throws a IntegerSetException if the set is empty
		public int largest() {
			
			
		};
		 
		public int smallest() throws IOException {
	        if (set.isEmpty()) {
	            throw new IOException("The set is empty");
	        }
	        int smallest = set.get(0);
	        for (int i = 1; i < set.size(); i++) {
	            if (set.get(i) < smallest) {
	                smallest = set.get(i);
	            }
	        }
	        return smallest;
	    }

//		​// Adds an item to the set or does nothing it already there​
		​public void add(int item) {
			
			
		}; // adds item to the set or does nothing if it is in set 
		 
//		​// Removes an item from the set or does nothing if not there
		public void remove(int item) {
			
			
		};
		 
		// Set union
		public void union(IntegerSet intSetb) {
			
		};
		 
		// Set intersection, all elements in s1 and s2
		public void intersect(IntegerSet intSetb) { 
		
		};
		 
		// Set difference, i.e., s1 –s2
		public void diff(IntegerSet intSetb) {
		} // set difference, i.e. s1 - s2
		 
		// Set complement, all elements not in s1
		public void complement(IntegerSet intSetb) {
		}
		 
		// Returns true if the set is empty, false otherwise
		boolean isEmpty() {
			return false;
		}
		 
		// Return String representation of your set.  This overrides the equal method from
		// the Object class.
		 
		public String toString() {
			
			
		​// return String representation of your set
		}
	}


