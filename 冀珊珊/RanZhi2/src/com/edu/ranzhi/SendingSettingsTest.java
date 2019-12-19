package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class SendingSettingsTest extends BaseTest {
	@Test(dataProvider = "sendingData", dataProviderClass = NSDataProvider.class)
	public void testSending(String fromAddress,String password) throws Exception {
		
		// 操作
		webtest.click("xpath=//a[contains(text(),'发信')]");
		webtest.click("xpath=//input[@id='turnon0']");
		webtest.type("id=fromAddress", fromAddress);
		webtest.click("xpath=//button[@id='submit']");
		webtest.type("password", password);
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("成功"));
	}
}
