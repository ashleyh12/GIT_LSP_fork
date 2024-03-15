package org.howard.edu.lsp.midterm.question2;

import javax.print.attribute.standard.MediaSize.Other;

@SuppressWarnings("unused")
public class IntegerRange implements Range {
	
    private int lowerBound;
    private int upperBound;
    /*
     * Integer range method: determining the upper and lower bound
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /*
     * Contains method to see whether the value is within the range
     */
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    /*
     * Overlaps method: determines whether two ranges overlap each other
     */
    public boolean overlaps(Range other) {
        if (other instanceof IntegerRange) {
            IntegerRange otherRange = (IntegerRange) other;
            return this.contains(otherRange.lowerBound) || this.contains(otherRange.upperBound);
        }
        return false;
    }

    /*
     * Size method: determines the size/length of a range
     */
    public int size() {
        return Math.abs(upperBound - lowerBound) + 1;
    }

    @Override
    /*
     * Equals method: determines if two ranges are equal to eachother
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegerRange)) {
            return false;
        }
        IntegerRange other = (IntegerRange) obj;
        return this.lowerBound == other.lowerBound && this.upperBound == other.upperBound;
    }

    /*
     * Contains1: Unimplemented method 
     */
	@Override
	public boolean contains1(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Overlaps1: unimplemented method
	 */
	@Override
	public boolean overlaps1(Range other) {
		// TODO Auto-generated method stub
		return false;
	}
    
   
}