package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerSet {
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

		    private boolean setEquals(List<Integer> set1, List<Integer> set2) {
		        return set1.size() == set2.size() && set1.containsAll(set2);
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

		// TODO Auto-generated method stub

	}


