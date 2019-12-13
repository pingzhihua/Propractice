package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class AddGroupTest extends BaseTest {
	
	@Test(dataProvider = "groupData", dataProviderClass = NSDataProvider.class)
	public void testAddGroup(String name, String desc) {

		// ����
		webtest.click("xpath=//a[contains(text(),'Ȩ��')]");
		webtest.click("xpath=//a[contains(text(),'��������')]");
		webtest.type("name=name", name);
		webtest.type("name=desc", desc);
		webtest.click("xpath=//button[@id='submit']");

		// ǩ��
		// webtest.leaveFrame();
		// webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
