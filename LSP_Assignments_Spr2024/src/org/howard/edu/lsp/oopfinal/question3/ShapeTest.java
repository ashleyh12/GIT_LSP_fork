package org.howard.edu.lsp.oopfinal.question3;
import static org.junit.Assert.*;
import org.junit.Test;

public class ShapeTest 
{
    @Test
    public void testCreateCircle() 
    {
        ShapeFactory factory = new ShapeFactory();
        Shape c = factory.createShape("circle");
        assertTrue(c instanceof Circle);
    }

    @Test
    public void testCreateRectangle() {
        ShapeFactory factory = new ShapeFactory();
        Shape r = factory.createShape("rectangle");
        assertTrue(r instanceof Rectangle);
    }
}
