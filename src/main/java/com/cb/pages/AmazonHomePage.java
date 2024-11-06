package com.cb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage {
	@FindBy(id = "nav-hamburger-menu")
	private WebElement hamburgerMenuLink;

	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamburgerMenuPage clickHamburger() {
		hamburgerMenuLink.click();
		return new AmazonHamburgerMenuPage();
	}

}
