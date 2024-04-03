package org.howard.edu.lsp.assignment5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows; // Correct import statement


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
    public void testLargest() throws IntegerSetException {
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
    public void testSmallest() throws IntegerSetException {
        set.add(5);
        set.add(10);
        assertEquals(5, set.smallest());
    }

    @Test
    @DisplayName("Test case for smallest with an empty set")
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
}

