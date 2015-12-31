package com.ilad.shape;

public class Circle extends Shape {

	private final double PI = 3.14159_26535_89793;
	protected double radius;
	
	public Circle() {
		radius = 1.0;
	}
	public Circle(double radius_) {
		radius = radius_;
	}
	public Circle(double radius_, String color_, boolean filled_) {
		radius = radius_;
		color = color_;
		filled = filled_;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius_) {
		radius = radius_;
	}
	
	@Override
	public double getArea() {
		return radius * radius * PI;
	}
	@Override
	public double getPerimeter() {
		return 2 * radius * PI;
	}
	
	@Override
	public String toString() {
		return "A Circle with radius = " + radius + ", which is a subclass of " + super.toString();
	}
}
