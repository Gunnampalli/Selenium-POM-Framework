package com.cb.pages;

import org.openqa.selenium.By;

import com.cb.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	OrangeHRMHomePage() {

	}

	private final By profileName = By.xpath("//p[.='Au eACqGdA']");
	private final By logout = By.xpath("//a[.='Logout']");

	public OrangeHRMHomePage clickProfile()  {
		click(profileName, WaitStrategy.ClICKABLE, "Profile Link");
		return this;
	}

	public OrangeHRMLoginPage clickLogout()  {
		click(logout, WaitStrategy.ClICKABLE, "LogOut Link");
		return new OrangeHRMLoginPage();
	}

}
