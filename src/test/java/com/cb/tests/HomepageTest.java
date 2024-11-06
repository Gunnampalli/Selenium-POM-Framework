package com.cb.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cb.driver.DriverManager;

public final class HomepageTest extends BaseTest {
	private HomepageTest() {

	}

	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("selenium testing", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		assertTrue(Objects.nonNull(title));
		assertTrue(title.toLowerCase().contains("google search"));
		assertTrue(title.length() > 15);
		assertTrue(title.length() < 100);
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
		assertTrue(elements.size() >15);
		boolean isElementPresent = false;
		for (WebElement webElement : elements) {
			if (webElement.getText().equalsIgnoreCase("selenium webDriver")) {
				isElementPresent = true;
				break;
			}
		}
		assertTrue(isElementPresent, "Selenium WebDriver not found");

	}
}
