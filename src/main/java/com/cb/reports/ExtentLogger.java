package com.cb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cb.driver.DriverManager;
import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;
import com.cb.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtent().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtent().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtent().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtent().info(message);
	}

	public static void pass(String message, boolean isScreenshotneeded)  {
		if (ReadPropertyFile.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotneeded) {
			ExtentManager.getExtent().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		} else {
			pass(message);
		}

	}

	public static void fail(String message, boolean isScreenshotneeded) {
		if (ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotneeded) {
			ExtentManager.getExtent().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		} else {
			fail(message);
		}

	}

	public static void skip(String message, boolean isScreenshotneeded) {
		if (ReadPropertyFile.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotneeded) {
			ExtentManager.getExtent().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		} else {
			skip(message);
		}

	}

	

}
