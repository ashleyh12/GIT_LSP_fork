package org.howard.edu.lsp.midterm.question2;

public class RangeTester {
    public static void main(String[] args) {
        // Create IntegerRange objects
        IntegerRange range1 = new IntegerRange(5, 10); //range 1 = 5-10
        IntegerRange range2 = new IntegerRange(8, 15); //range 2 = 8-15
        IntegerRange range3 = new IntegerRange(1, 3);  //range 3 = 1-3

        // Testing the contains method
        System.out.println("range1 contains 7: " + range1.contains(7)); // output should be true
        System.out.println("range1 contains 15: " + range1.contains(15)); // output should be false

        // Testing the overlaps method
        System.out.println("range1 overlaps range2: " + range1.overlaps(range2)); // output should be true
        System.out.println("range1 overlaps range3: " + range1.overlaps(range3)); // output should be false

        // Testinging the size method
        System.out.println("Size of range1: " + range1.size()); // answer should be 6

        // Testing the equals method
        IntegerRange range4 = new IntegerRange(5, 10); //range four = 5-10
        System.out.println("range1 equals range4: " + range1.equals(range4)); // output should be true
    }
}
