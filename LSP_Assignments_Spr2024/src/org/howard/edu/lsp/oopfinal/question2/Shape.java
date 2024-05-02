package org.howard.edu.lsp.oopfinal.question2;

// Shape.java
public interface Shape {
   void draw();
}

// Circle.java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Circle!!!");
    }
}

// Rectangle.java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Rectangle!!!");
    }
}

// ShapeFactory.java
public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape c = factory.createShape("circle");
        c.draw();

        Shape r = factory.createShape("rectangle");
        r.draw();
    }
}
