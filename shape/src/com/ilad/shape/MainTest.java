package com.ilad.shape;

public class MainTest {
	public static void main(String args[]) {
		System.out.println("Hello world!");
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(5);
		Circle circle3 = new Circle(10, "red", false);
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle(5, 4);
		Rectangle rectangle3 = new Rectangle(10, 3, "yellow", false);
		Square square1 = new Square();
		Square square2 = new Square(2);
		Square square3 = new Square(5, "blue", false);
		
		System.out.println("circle1: " + circle1);
		System.out.println("circle2: " + circle2);
		System.out.println("circle3: " + circle3);
		System.out.println("rectangle1: " + rectangle1);
		System.out.println("rectangle2: " + rectangle2);
		System.out.println("rectangle3: " + rectangle3);
		System.out.println("square1: " + square1);
		System.out.println("square2: " + square2);
		System.out.println("square3: " + square3);
		System.out.println("radius of circle1: " + circle1.getRadius());
		System.out.println("area of circle2: " + circle2.getArea());
		System.out.println("perimeter of circle3: " + circle3.getPerimeter());
		System.out.println("width of rectangle1: " + rectangle1.getWidth());
		System.out.println("length of rectangle2: " + rectangle2.getLength());
		System.out.println("area of rectangle3: " + rectangle3.getArea());
		System.out.println("perimeter of rectangle3: " + rectangle3.getPerimeter());
		System.out.println("width of square1: " + square1.getWidth());
		System.out.println("length of square2: " + square2.getLength());
		System.out.println("side of square2: " + square2.getSide());
		System.out.println("area of square3: " + square3.getArea());
		System.out.println("perimeter of square3: " + square3.getPerimeter());

		/**
		 * For the Exercise at workshhet4
		 */
/*		Shape s1 = new Circle(5.5, "RED", false);
		System.out.println(s1);
		System.out.println(s1.getArea());
		System.out.println(s1.getPerimeter());
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
//		System.out.println(s1.getRadius());
		
		Circle c1 = (Circle)s1;
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		
//		Shape s2 = new Shape();
		
		Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
//		System.out.println(s3.getLength());
		
		Rectangle r1 = (Rectangle)s3;
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());
		
		Shape s4 = new Square(6.6);
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
//		System.out.println(s4.getSide());
		
		Rectangle r2 = (Rectangle)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
//		System.out.println(r2.getSide());
		System.out.println(r2.getLength());
		
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());
*/	}
}
