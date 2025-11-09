import shapes.rectangle;
import shapes.square;
import shapes.shape;

public class Main {
    public static void main(String[] args) {
        // Demonstrate Liskov Substitution Principle

        // Using Rectangle
        rectangle rectangle = new rectangle(5, 10);
        System.out.println("Rectangle area: " + rectangle.getArea());

        // Using Square
        square square = new square(5);
        System.out.println("Square area: " + square.getArea());

        // LSP demonstration: Both can be treated as Shape
        System.out.println("\n--- LSP Demonstration ---");

        shape shape1 = new rectangle(3, 4);
        shape shape2 = new square(3);

        // Both can be used interchangeably as Shape
        printArea(shape1);
        printArea(shape2);

        // This works without knowing the specific type
        shape[] shapes = {new rectangle(2, 3), new square(4)};
        System.out.println("\n--- Processing shapes array ---");
        for (shape shape : shapes) {
            printArea(shape);
        }
    }

    // Method that accepts any Shape (follows LSP)
    public static void printArea(shape shape) {
        System.out.println("Shape area: " + shape.getArea());
    }
}