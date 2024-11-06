package com.cb.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void pageFactoryDemoTest() {
		PageFactoryDemo pfd = new PageFactoryDemo(driver);
		pfd.findElements10times();
	}

	@Test(priority = 2)
	public void pageFactoryDemoWithCacheTest() {
		PageFactoryDemoWithCache pfdc = new PageFactoryDemoWithCache(driver);
		pfdc.findElements10times();
	}

	@Test(priority = 3)
	public void noPageFactoryDemoTest() {
		NoPageFactory npf = new NoPageFactory(driver);
		npf.findElements10times();

	}

}
