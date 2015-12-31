package com.ilad.shape;

public abstract class Shape {
	
	protected String color;
	protected boolean filled;
	
	public Shape() {
		color = "green";
		filled = true;
	}
	public Shape(String color_, boolean filled_) {
		color = color_;
		filled = filled_;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color_)	{
		color = color_;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled_) {
		filled = filled_;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	@Override
	public String toString() {
		if(true == filled) {
			return "A Shape with color of " + color + " and filled";
		}
		
		return "A Shape with color of " + color + " and not filled";
	}
}
