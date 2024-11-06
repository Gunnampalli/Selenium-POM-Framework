package com.cb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cb.driver.DriverManager;

public final class LoginpageTest extends BaseTest {
	private LoginpageTest() {

	}

	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

	}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);

	}

}
