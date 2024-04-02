package org.howard.edu.lsp.assignment4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerSet {
    private static final Collection<?> temp = null;
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

    
	    /***
	     * Clears the internal representation of the set
	     * 
	     */
		public void clear() {
			set.clear();
			
		};
		 
	    /***
	     * Returns the length of the set
	     * 
	     */
		public int length() {
			return set.size();
			
		}; // returns the length

		
		/*
		* Returns true if the 2 sets are equal, false otherwise;
		* Two sets are equal if they contain all of the same values in ANY order.  This overrides
		* the equal method from the Object class.
		*/
		
		public boolean equals(IntegerSet o) {
			ArrayList<Integer>set2 = (ArrayList<Integer>) o.set;
			for (Integer i : set) {
	            if (!set2.contains(i)) {
	                return false;
	            }
			}
			return true;
		};
	
	
		 
	    /***
	     * Returns true if the set contains the value, otherwise false
	     * 
	     */
		public boolean contains(int value) {
			return set.contains(value);
			
		};    
		 
		
	    /***
	     * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	     * 
	     */
		public int largest() throws IntegerSetException {
	        if (set.isEmpty()) {
	            throw new IntegerSetException(null);
	        }
	        int largest = set.get(0);
	        for (int i = 1; i < set.size(); i++) {
	            if (set.get(i) > largest) {
	                largest = set.get(i);
	            }
	        }
	        return largest;
	    };
		
			
	    /***
	     * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	     * 
	     */
		public int smallest() throws IntegerSetException {
	        if (set.isEmpty()) {
	            throw new IntegerSetException(null);
	        }
	        int smallest = set.get(0);
	        for (int i = 1; i < set.size(); i++) {
	            if (set.get(i) < smallest) {
	                smallest = set.get(i);
	            }
	        }
	        return smallest;
	    }
		
	    /***
	     * Adds an item to the set or does nothing it already there​ boolean
	     * 
	     */
		public void add(int item) {
			boolean existItem = false;  
			for (int i = 0; i < set.size(); i++) {
				if (set.get(i) == item) {
					existItem = true;
				}
				else {
					set.add(item);
				}
			}
			
		}; 
		 
	    /***
	     * Removes an item from the set or does nothing if not there
	     * 
	     */
		public void remove(int item) {
			for(int i = 0; i < set.size(); i++) {
				if(set.get(i) == item)
				{
					set.remove(i);
				}
			}
			
		};
		 
	    /***
	     * Set union
	     * 
	     */
		public IntegerSet union(IntegerSet intSetb) {
			ArrayList<Integer>set1 = intSetb.get();
			Set<Integer>set2 = new HashSet<Integer>();
			set2.addAll(set1); //adding everything from set1 into set 2
			set2.addAll(set2); //adding everything from set 2 into set 2
			ArrayList<Integer> set3 = new ArrayList<>(set2);
			IntegerSet unionSet = new IntegerSet(set3);
			return unionSet;
		};
		 
		ArrayList<Integer> get() {
			return new ArrayList<>(set);
		};
		
		
	    /***
	     * Set intersection, all elements in s1 and s2
	     * 
	     */
		public IntegerSet intersect(IntegerSet intSetb) { 
		    set.retainAll(intSetb.set);
			return intSetb;


		};
		 
	    /***
	     * Set difference, i.e., s1 –s2
	     * 
	     */
		public IntegerSet diff(IntegerSet intSetb) {
			ArrayList<Integer> set2 = intSetb.get();
			// Removing all the elements in set2 from set1
			set.removeAll(set2);
			IntegerSet DiffSet = new IntegerSet((ArrayList<Integer>) set);
			return DiffSet;
			
		} 
		 
	    /***
	     * Set complement, all elements not in s1
	     * 
	     */
		public void complement(IntegerSet intSetb) {
			List<Integer> setB = intSetb.get();
	        for (Integer item:setB) {
	            if (set.contains(item)) {
	                set.remove(item);
	            }
	        }
	    };
	
	    
	    /***
	     * Returns true if the set is empty, false otherwise
	     * 
	     */
		public boolean isEmpty() {
			for(int i = 0; i < set.size(); i++)
			{
				if(set.isEmpty())
				{
					return true;
				}
			}
			return false;
		};
		 
		
	    /***
	     * Return String representation of your set.  This overrides the equal method from 
	     * the Object class.
	     * 
	     */
		public String toString() {
			return set.toString();
		};
		
		
} 
//// 		!!!!!!!!!!
//
//
//			Javadoc, HTML Doc: file:///Users/ashleyhaynes/GIT_LSP_fork/LSP_Assignments_Spr2024/src/org/howard/edu/lsp/assignment4/org/howard/edu/lsp/assignment4/package-summary.html
//
//		!!!!!!!!!!
//	
//	

