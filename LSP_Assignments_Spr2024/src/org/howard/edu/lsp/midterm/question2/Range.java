package org.howard.edu.lsp.midterm.question2;

public interface Range {
    boolean contains1(int value);
    boolean overlaps1(Range other);
    int size();
	boolean contains(int value);
	boolean overlaps(Range other);

}
