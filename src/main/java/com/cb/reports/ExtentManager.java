package com.cb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> eTest = new ThreadLocal<>();

	public static void setExtent(ExtentTest test) {
		eTest.set(test);
	}

	public static ExtentTest getExtent() {
		return eTest.get();
	}
	
	public static void removeTest()
	{
	 eTest.remove();
	}

}
