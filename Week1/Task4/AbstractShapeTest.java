package Week1;

//Abstract class Shape
abstract class Shape {
// Abstract method
abstract double area();
}

//Circle class extends Shape
class Circle extends Shape {
private double radius;

// Constructor
public Circle(double radius) {
   this.radius = radius;
}

// Implement area method
@Override
double area() {
   return Math.PI * radius * radius;
}
}

//Rectangle class extends Shape
class Rectangle extends Shape {
private double length;
private double breadth;

// Constructor
public Rectangle(double length, double breadth) {
   this.length = length;
   this.breadth = breadth;
}

// Implement area method
@Override
double area() {
   return length * breadth;
}
}

//Main class
public class AbstractShapeTest {
public static void main(String[] args) {
   // Create Circle and Rectangle objects
   Shape circle = new Circle(6.0);
   Shape rectangle = new Rectangle(10.0, 2.0);

   // Print area
   System.out.println("Area of Circle: " + circle.area());
   System.out.println("Area of Rectangle: " + rectangle.area());
}
}

