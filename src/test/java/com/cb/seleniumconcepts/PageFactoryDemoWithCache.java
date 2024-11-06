package com.cb.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemoWithCache {
	
	@CacheLookup
	@FindBy(name = "q")
	private WebElement search;

	private WebDriver driver;

	public PageFactoryDemoWithCache(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void findElements10times() {

		long startime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			search.clear();
			search.sendKeys("Testing");
		}

		System.out.println(System.currentTimeMillis() - startime);

	}

}
