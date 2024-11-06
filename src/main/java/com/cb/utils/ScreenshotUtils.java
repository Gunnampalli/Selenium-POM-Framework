package com.cb.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cb.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils()
	{
		
	}

	public static String getBaseImage() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
