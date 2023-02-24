package com.bridgelabz.qa.testngListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class My_testListener implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test is passed .NAme of test case "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test is failed .NAme of test case "+result.getName());
	}

}
