package com.ilad.testcalculator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenTestCalculator implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Reporter.log(arg0 + " Test failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log(arg0 + " Test skipped", true);;
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		Reporter.log(arg0 + " Test started", true);		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		Reporter.log(arg0 + " Test finished successfully", true);		
	}
}
