package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class BackUpTest extends BaseTest {

	@Test(dataProvider = "backupData", dataProviderClass = NSDataProvider.class)
	public void testBackUp(String day) {
		// 操作
		webtest.click("xpath=//a[contains(text(),'备份')]");
		webtest.click("xpath=//a[contains(text(),'设置保存天数')]");
		webtest.typeAndClear("id=saveDays", day);
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//*[@class='btn btn-primary backup']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
	}
}
