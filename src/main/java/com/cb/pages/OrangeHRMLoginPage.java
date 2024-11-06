package com.cb.pages;

import org.openqa.selenium.By;

import com.cb.enums.WaitStrategy;
import com.cb.reports.ExtentLogger;
import com.cb.utils.DecodeUtils;

public final class OrangeHRMLoginPage extends BasePage {

	private final By username = By.xpath("//input[@name='username']");
	private final By password = By.xpath("//input[@name='password' and @type='password']");
	private final By login = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginPage enterUserName(String name)  {

		sendKeys(username, name, WaitStrategy.VISIBLE, "username textbox");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String pwd)  {
		sendKeys(password, DecodeUtils.getDecode(pwd), WaitStrategy.VISIBLE, "Password textbox");
		return this;
	}

	public OrangeHRMHomePage clickLogin()  {
		click(login, WaitStrategy.ClICKABLE, "Login button");
		return new OrangeHRMHomePage();
	}
}
