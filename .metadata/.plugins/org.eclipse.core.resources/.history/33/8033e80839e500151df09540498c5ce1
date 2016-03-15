package com.ilad.complexnumber;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		ComplexNumber number1 = new ComplexNumber();
		ComplexNumber number2 = new ComplexNumber(3);
		ComplexNumber number3 = new ComplexNumber(5, 6);
		ComplexNumber number4 = new ComplexNumber(number3);
		ComplexNumber number5 = new ComplexNumber(number3);
		ComplexNumber number6 = new ComplexNumber();
		ComplexNumber number7 = new ComplexNumber(5);
		ComplexNumber number8 = new ComplexNumber(0, 4);
		int number9 = 5;
		
		System.out.println("number1: " + number1);
		System.out.println("number2: " + number2);
		System.out.println("number3: " + number3);
		System.out.println("number4: " + number4);
		System.out.println("number5: " + number5);
		
		System.out.println("getReal of number3 = " + number3.getReal());
		System.out.println("getImaginaty of number4 = " + number4.getImaginary());
		
		number1.setValue(1, 2);
		number4.setReal(7);
		number2.setImagine(4);
		
		System.out.println("number1: " + number1);
		System.out.println("number2: " + number2);
		System.out.println("number3: " + number3);
		System.out.println("number4: " + number4);
		System.out.println("number5: " + number5);
		
		System.out.println("isReal of number6 = " + number6.isReal());
		System.out.println("isImagine of number6 = " + number6.isImaginary());
		System.out.println("isReal of number7 = " + number7.isReal());
		System.out.println("isImagine of number7 = " + number7.isImaginary());
		System.out.println("isReal of number8 = " + number8.isReal());
		System.out.println("isImagine of number8 = " + number8.isImaginary());
		System.out.println("isReal of number3 = " + number3.isReal());
		System.out.println("isImagine of number8 = " + number3.isImaginary());
		
		number6 = number1.add(number2);
		System.out.println("number6: " + number6);
		
		number6 = number1.subtract(number2);
		System.out.println("number6: " + number6);
		
		number6 = number1.multiply(number2);
		System.out.println("number6: " + number6);
		
		number6 = number1.divide(number2);
		System.out.println("number6: " + number6);
		
		number6 = number7;
		System.out.println("equals of number6 & number7 " + number6.equals(number7));
		System.out.println("equals of number6 & null " + number6.equals(null));
		System.out.println("equals of number6 & number9 " + number6.equals(number9));
		System.out.println("equals of number7 & number3 " + number7.equals(number3));
		System.out.println("equals of number8 & number2 " + number8.equals(number2));
		System.out.println("equals of number8 & number8 " + number8.equals(number8));
		System.out.println("equals of number5 & number3 " + number5.equals(number3));
	}

}
