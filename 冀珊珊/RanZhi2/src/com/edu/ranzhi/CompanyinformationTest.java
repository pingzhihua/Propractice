package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

import org.testng.annotations.Test;

//@Listeners(WebTestListener.class)
public class CompanyinformationTest extends BaseTest {
	@Test(dataProvider = "companyData", dataProviderClass = NSDataProvider.class)
	public void testCompany(String name, String body) throws InterruptedException {

		webtest.click("xpath=//*[contains(text(),'公司信息')]");
		webtest.typeAndClear("name=name", name);
		// 进文本框有三种方式：1、直接tab2、enterframe方法可以用int（即frame个数），或者，用id，名字，或者也可用xpath，即：封装重载了三种方法
		webtest.tapClick();
		// webtest.enterFrame("ke-edit-iframe");
		// webtest.enterFrame(0);
		// 直接在body里面输入东西
		webtest.type("tag=body", body);
		webtest.tapClick();
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='close-win']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
	}
}
