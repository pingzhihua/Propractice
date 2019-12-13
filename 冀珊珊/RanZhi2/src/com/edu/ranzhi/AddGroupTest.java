package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class AddGroupTest extends BaseTest {
	
	@Test(dataProvider = "groupData", dataProviderClass = NSDataProvider.class)
	public void testAddGroup(String name, String desc) {

		// 操作
		webtest.click("xpath=//a[contains(text(),'权限')]");
		webtest.click("xpath=//a[contains(text(),'新增分组')]");
		webtest.type("name=name", name);
		webtest.type("name=desc", desc);
		webtest.click("xpath=//button[@id='submit']");

		// 签退
		// webtest.leaveFrame();
		// webtest.click("xpath=//a[contains(text(),'签退')]");
	}
}
