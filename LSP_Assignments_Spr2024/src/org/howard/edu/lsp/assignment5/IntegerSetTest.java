package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows; // Correct import statement

import org.howard.edu.lsp.assignment4.IntegerSet;

public class IntegerSetTest {

    private IntegerSet set;

    @BeforeEach
    void setUp() {
        set = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        set.add(5);
        set.add(10);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        set.add(5);
        set.add(10);
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet setB = new IntegerSet();
        set.add(5);
        set.add(10);
        setB.add(5);
        setB.add(10);
        assertTrue(set.equals(setB));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set.add(5);
        set.add(10);
        assertTrue(set.contains(5));
        assertFalse(set.contains(15));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws org.howard.edu.lsp.assignment4.IntegerSetException {
        set.add(5);
        set.add(10);
        assertEquals(10, set.largest());
    }

    @Test
    @DisplayName("Test case for largest with empty set")
    public void testExceptionLargestEmptySet() {
        assertThrows(IntegerSetException.class, () -> set.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws org.howard.edu.lsp.assignment4.IntegerSetException {
        set.add(5);
        set.add(10);
        assertEquals(5, set.smallest());
    }

    @Test
    @DisplayName("Test case for smallest with empty set")
    public void testExceptionSmallestEmptySet() {
        assertThrows(IntegerSetException.class, () -> set.smallest());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set.add(5);
        set.add(10);
        assertTrue(set.contains(5));
        assertTrue(set.contains(10));
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set.add(5);
        set.add(10);
        set.remove(5);
        assertFalse(set.contains(5));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet setB = new IntegerSet();
        set.add(5);
        set.add(10);
        setB.add(15);
        set.union(setB);
        assertTrue(set.contains(5));
        assertTrue(set.contains(10));
        assertTrue(set.contains(15));
    }

    @Test
    @DisplayName("Test case for intersection")
    public void testIntersect() {
        IntegerSet setB = new IntegerSet();
        set.add(5);
        set.add(10);
        setB.add(10);
        setB.add(15);
        set.intersect(setB);
        assertTrue(set.contains(10));
        assertFalse(set.contains(5));
        assertFalse(set.contains(15));
    }

    @Test
    @DisplayName("Test case for difference")
    public void testDiff() {
        IntegerSet setB = new IntegerSet();
        set.add(5);
        set.add(10);
        setB.add(10);
        setB.add(15);
        set.diff(setB);
        assertTrue(set.contains(5));
        assertFalse(set.contains(10));
        assertFalse(set.contains(15));
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        IntegerSet setB = new IntegerSet();
        set.add(5);
        set.add(10);
        setB.add(10);
        setB.add(15);
        set.complement(setB);
        assertTrue(set.contains(15));
        assertFalse(set.contains(10));
        assertFalse(set.contains(5));
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(set.isEmpty());
        set.add(5);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        set.add(5);
        set.add(10);
        assertEquals("[5, 10]", set.toString());
    }


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
}

class IntegerSetException extends RuntimeException {
    public IntegerSetException(String message) {
        super(message);
    }
}
}
