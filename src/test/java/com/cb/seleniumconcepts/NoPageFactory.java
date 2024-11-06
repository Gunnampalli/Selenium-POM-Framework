package com.cb.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class NoPageFactory  {

	private final By search = By.name("q");

	private static WebDriver driver;

	public NoPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void findElements10times() {

		long startime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			driver.findElement(search).clear();
			driver.findElement(search).sendKeys("Testing");
		}

		System.out.println(System.currentTimeMillis() - startime);

	}


}
