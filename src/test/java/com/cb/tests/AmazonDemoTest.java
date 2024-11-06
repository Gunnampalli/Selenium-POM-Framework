package com.cb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.constants.CategoryType;
import com.cb.driver.DriverManager;
import com.cb.pages.AmazonHomePage;
import com.cb.utils.DataProviderUtils;

public final class AmazonDemoTest extends BaseTest {

	private AmazonDemoTest() {

	}

	@FrameworkAnnotation(author = "venkatesh", category = { CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void amazonTest(Map<String, String> m) {
		new AmazonHomePage().clickHamburger().clickMobileAndComputers().clickSubMenu("Laptops");
		Assert.assertEquals(DriverManager.getDriver().getTitle(),
				"Laptops: Buy Laptop Online with Up to 60% OFF at Amazon.in");
	}

}
