package com.ilad.shape;

public class Square extends Rectangle {
	
	private double side;

	public Square() {
		side = 1.0;
	}
	public Square(double side_) {
		side = side_;
	}
	public Square(double side_, String color_, boolean filled_) {
		side = side_;
		color = color_;
		filled = filled_;
	}
	
	public double getSide() {
		return side;
	}
	public void setSide(double side_) {
		side = side_;
	}
	
	@Override
	public void setWidth(double side_) {
		width = side_;
	}
	@Override
	public void setLength(double side_) {
		length = side_;
	}
	
	@Override
	public double getArea() {
		return side * side;
	}
	@Override
	public double getPerimeter() {
		return 4 * side;
	}
		
	@Override
	public String toString() {
		setWidth(side);
		setLength(side);
		return "A Square with side = " + side + ", which is a subclass of " + super.toString();
	}
}
