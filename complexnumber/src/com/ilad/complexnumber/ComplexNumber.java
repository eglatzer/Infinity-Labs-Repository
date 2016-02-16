package com.ilad.complexnumber;

public class ComplexNumber {
	private double m_real;
	private double m_imagine;
	
	public ComplexNumber(){
		
	}
	
	public ComplexNumber(double real_){
		this(real_, 0);
	}
	
	public ComplexNumber(double real_, double imaginary_){
		m_real = real_;
		m_imagine = imaginary_;
	}
	
	public ComplexNumber(ComplexNumber other_){
		assert(null != other_);
		m_real = other_.m_real;
		m_imagine = other_.m_imagine;
	}
	
	public double getReal(){
		return m_real;
	}
	
	public ComplexNumber setReal(double real_) {
		m_real = real_;
		return this;
	}
	
	public double getImaginary(){
		return m_imagine;
	}
	
	public ComplexNumber setImagine(double imaginary_) {
		m_imagine = imaginary_;
		return this;
	}
	
	public ComplexNumber setValue(double real_, double imaginary_) {
		m_real = real_;
		m_imagine = imaginary_;
		return this;
	}
	
	public boolean isReal() {
		return 0 == m_imagine;
	}
	
	public boolean isImaginary() {
		return (0 == m_real && 0 != m_imagine);
	}
	
	public ComplexNumber add(ComplexNumber other_) {
		assert(null != other_);
		return new ComplexNumber(m_real + other_.m_real, m_imagine + other_.m_imagine);
	}
	
	public ComplexNumber subtract(ComplexNumber other_) {
		assert(null != other_);
		return new ComplexNumber(m_real - other_.m_real, m_imagine - other_.m_imagine);
	}
	
	public ComplexNumber multiply(ComplexNumber other_) {
		assert(null != other_);
		ComplexNumber newNumber = new ComplexNumber();
		newNumber.setReal(m_real * other_.m_real - m_imagine * other_.m_imagine);
		newNumber.setImagine(m_imagine * other_.m_real + m_real * other_.m_imagine);
		return newNumber;
	}
	
	public ComplexNumber divide(ComplexNumber other_) {
		assert(null != other_);
		ComplexNumber newNumber = new ComplexNumber();
		newNumber.setReal((m_real * other_.m_real + m_imagine * other_.m_imagine) /
						  (this.square(other_.m_real) + this.square(other_.m_imagine)));
		newNumber.setImagine((m_imagine * other_.m_real - m_real * other_.m_imagine) /
				  			 (this.square(other_.m_real) + this.square(other_.m_imagine)));
		return newNumber;
	}
	
	private double square(double to_double)
	{
		return to_double * to_double;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(m_imagine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m_real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNumber other = (ComplexNumber) obj;
		if (Double.doubleToLongBits(m_imagine) != Double.doubleToLongBits(other.m_imagine))
			return false;
		if (Double.doubleToLongBits(m_real) != Double.doubleToLongBits(other.m_real))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + m_real + ", " + m_imagine + "]";
	}
}
