package com.cb.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocators {

	private WebDriver driver;
	private String menuitem = "//a[@class='hmenu-item']/div[.='%value%']";

	public DynamicLocators(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMenu(String name) {

		driver.findElement(By.xpath(menuitem.replace("%value%", name)));
	}

}
