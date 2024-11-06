package com.cb.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cb.constants.FrameworkConstants;
import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (WaitStrategy.ClICKABLE == waitStrategy) {
			element = elementToBeClickable(by);
			
		} else if (WaitStrategy.PRESENCE == waitStrategy) {
			element = elementToBePresent(by);
		} else if (WaitStrategy.VISIBLE == waitStrategy) {
			element = elementToBeVisible(by);
		} else if (WaitStrategy.NONE == waitStrategy) {
			element = null;

		}
		return element;
	}

	private static WebElement elementToBeClickable(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	private static WebElement elementToBePresent(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	private static WebElement elementToBeVisible(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
