package com.cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;
import com.cb.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	@FindBy(xpath = "//div[.='Mobiles, Computers']/parent::a")
	private WebElement mobileAndComputersLink;

	@FindBy(xpath = "//a[.='Laptops']")
	private WebElement laptopsLink;

	@FindBy(xpath = "//a[.='Drives & Storage']")
	private WebElement driversAndStorageLink;

	@FindBy(xpath = "//a[.='Printers & Ink']")
	private WebElement printersAndInkLink;

	private String subMenuLink = "//a[.='%s']";

	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonLaptopPage clickSubMenu(String menuText) {
		String newXpath = DynamicXpathUtils.getXpath(subMenuLink, menuText);
		try {
			click(By.xpath(newXpath), WaitStrategy.ClICKABLE, menuText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (menuText.contains("Laptops"))
			return new AmazonLaptopPage();
		return null;
	}

	public AmazonHamburgerMenuPage clickMobileAndComputers() {
		mobileAndComputersLink.click();
		return this;
	}

	public AmazonLaptopPage clickLaptops() {
		laptopsLink.click();
		return new AmazonLaptopPage();
	}

	public AmazonDriversAndStoragePage clickDriversAndStorage() {
		driversAndStorageLink.click();
		return new AmazonDriversAndStoragePage();
	}

	public AmazonPrintersAndInkPage clickPrintersAndInk() {
		printersAndInkLink.click();
		return new AmazonPrintersAndInkPage();
	}

}
