package com.cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cb.enums.WaitStrategy;
import com.cb.factories.ExplicitWaitFactory;
import com.cb.reports.ExtentLogger;

public class BasePage {

	public void click(By by, WaitStrategy waitStrategy, String elementName)  {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy).findElement(by);
		element.click();
		ExtentLogger.pass(elementName + " is Clicked",true);
	}

	public void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName)  {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy).findElement(by);
		element.clear();
		element.sendKeys(value);
		ExtentLogger.pass("Enter the text " + value + " in " + elementName,true);
	}

}
