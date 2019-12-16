package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

import static org.testng.Assert.assertTrue;

public class AddPlanTest extends BaseTest {

	@Test(dataProvider = "planData", dataProviderClass = NSDataProvider.class)
	public void testplan(String minute, String hour,String dom,String mon,String dow,String command) {
		// 操作
		webtest.click("xpath=//a[contains(text(),'计划任务')]");
		webtest.click("xpath=//a[contains(text(),'添加')]");

		webtest.type("name=m", minute);
		webtest.type("name=h", hour);
		webtest.type("name=dom", dom);
		webtest.type("name=mon", mon);
		webtest.type("name=dow", dow);
		webtest.type("name=command", command);
		webtest.selectByIndex("id=type", 0);
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("正常"));
	}
}
