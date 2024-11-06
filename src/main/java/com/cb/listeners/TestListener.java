package com.cb.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.reports.ExtentLogger;
import com.cb.reports.ExtentReport;

public class TestListener implements ISuiteListener, ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentLogger.pass(result.getMethod().getMethodName() + "is passed", true);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		// ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + "is Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		/*
		 * For now we are not implementing it
		 */
	}

	@Override
	public void onStart(ITestContext context) {

		/*
		 * For now we have only test in suite
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * For now we have only test in suite
		 */

	}

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();

	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();

	}

}
