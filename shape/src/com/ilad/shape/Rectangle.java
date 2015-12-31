package com.ilad.shape;

public class Rectangle extends Shape {
	
	protected double width;
	protected double length;
	
	public Rectangle() {
		width = 1.0;
		length = 1.0;
	}
	public Rectangle(double width_, double length_) {
		width = width_;
		length = length_;
	}
	public Rectangle(double width_, double length_, String color_, boolean filled_) {
		width = width_;
		length = length_;
		color = color_;
		filled = filled_;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width_) {
		width = width_;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length_) {
		length = length_;
	}
	
	@Override
	public double getArea() {
		return width * length;
	}
	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}
	
	@Override
	public String toString() {
		return "A Rectangle with width = " + width + " and length = " + length +
					", which is a subclass of " + super.toString();
	}
}
