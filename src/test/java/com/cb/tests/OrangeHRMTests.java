package com.cb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.constants.CategoryType;
import com.cb.driver.DriverManager;
import com.cb.pages.OrangeHRMHomePage;
import com.cb.pages.OrangeHRMLoginPage;
import com.cb.utils.DataProviderUtils;


public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}

	@FrameworkAnnotation(author = "venkatesh", category = { CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void loginLogoutTest(Map<String, String> m)  {
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		OrangeHRMHomePage ohhp = ohlp.enterUserName(m.get("UserName")).enterPassword(m.get("Password")).clickLogin();
		ohhp.clickProfile().clickLogout();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");

	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void newTest(Map<String, String> m) {
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		OrangeHRMHomePage ohhp = ohlp.enterUserName(m.get("UserName")).enterPassword(m.get("Password")).clickLogin();
		ohhp.clickProfile().clickLogout();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");

	}

}
