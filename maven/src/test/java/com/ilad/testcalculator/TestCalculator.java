package com.ilad.testcalculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ilad.calculator.Calculator;

public class TestCalculator {

	Calculator calculator;
	final int X = 6;
	final int ZERO = 0;

	@BeforeMethod
	public void setCalculator() {
		calculator = new Calculator();
	}

	@DataProvider(name = "testAddition")
	private static Object[][] intsToTest() {
		return new Object[][] {{4, 2}, {20, -5}, {-21, 7}, {-55, -11}};
	}

	@Test(description = "Tests the method Calculator.add(x, y)",
		  dataProvider = "testAddition")
	public void testAddition(Integer x, Integer y) {
		Assert.assertEquals(calculator.add(x, y), x + y);
	}

	@Test(description = "Tests the method Calculator.subtract(x, y)",
		  dependsOnMethods = {"testAddition"}, alwaysRun=true,
		  dataProvider = "testAddition")
	public void testSubtraction(Integer x, Integer y) {
		Assert.assertEquals(calculator.subtract(x, y), x - y);
	}

	@Test(description = "Tests the method Calculator.multiply(x, y)",
		  dependsOnMethods = {"testSubtraction"}, alwaysRun=true,
		  dataProvider = "testAddition")
	public void testMultiplication(Integer x, Integer y) {
		Assert.assertEquals(calculator.multiply(x, y), x * y);
	}

	@Test(description = "Tests the method Calculator.divide(x, y)",
		  dependsOnMethods = {"testMultiplication"}, alwaysRun=true,
		  dataProvider = "testAddition")
	public void testDivision(Integer x, Integer y) {
		Assert.assertEquals(calculator.divide(x, y), x / y);
	}

	@Test(expectedExceptions = ArithmeticException.class,
		  description = "Tests if this method throws ArithmeticException in division by zero",
		  dependsOnMethods = {"testDivision"}, alwaysRun=true)
	public void testDivisionByZero() {
		calculator.divide(X, ZERO);
	}

	@Test(expectedExceptions = ArithmeticException.class,
		  description = "Tests if this method throws ArithmeticException in division of zero by zero",
		  dependsOnMethods = {"testDivisionByZero"}, alwaysRun=true)
	public void testDivisionZeroByZero() {
		calculator.divide(ZERO, ZERO);
	}
}
