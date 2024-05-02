package org.howard.edu.lsp.oopfinal.question3;

public class Client {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape c = factory.createShape("circle");
        c.draw();

        Shape r = factory.createShape("rectangle");
        r.draw();
    }
}
