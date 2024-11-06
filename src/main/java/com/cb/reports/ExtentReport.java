package com.cb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cb.constants.CategoryType;
import com.cb.constants.FrameworkConstants;
import com.cb.exceptions.ExtentFilePathException;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports report;

	public static void initReports()  {
		if (Objects.isNull(report)) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfolderpath());
			spark.config().setDocumentTitle("OrangeHRMS Report");
			spark.config().setReportName("Login Logout Testcases");
			report.attachReporter(spark);
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(report)) {
			report.flush();
			ExtentManager.removeTest();
		}
		try {

			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfolderpath()).toURI());
		} catch (IOException e) {
			throw new ExtentFilePathException("Extent File path not found");
		}
	}

	public static void createTest(String testName) {
		ExtentManager.setExtent(report.createTest(testName));
	}

	public static void addAuthors(String[] authorName) {
		for (String name : authorName) {
			ExtentManager.getExtent().assignAuthor(name);
		}
	}

	public static void addCategory(CategoryType[] categoryName) {
		for (CategoryType cName : categoryName) {
			ExtentManager.getExtent().assignCategory(cName.toString());
		}
	}

}
