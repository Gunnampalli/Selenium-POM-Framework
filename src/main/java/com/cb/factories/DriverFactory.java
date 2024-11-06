package com.cb.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;
		String runMode = ReadPropertyFile.get(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {
			if (runMode.equalsIgnoreCase("remote")) {
				ChromeOptions opt = new ChromeOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runMode.equalsIgnoreCase("remote")) {
				FirefoxOptions opt = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
			} else {
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
