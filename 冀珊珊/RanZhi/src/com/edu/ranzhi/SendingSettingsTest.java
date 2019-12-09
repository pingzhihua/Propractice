package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class SendingSettingsTest extends BaseTest{
	@Test
	public void testXuanxuan() throws Exception{
	//µÇÂ¼
	webtest.open("http://localhost/ranzhi/www");
	webtest.type("name=account","admin");
	webtest.type("name=password", "123456");
	webtest.click("xpath=//button[@id='submit']");
	webtest.click("xpath=//button[@data-id='superadmin']");
	webtest.enterFrame("iframe-superadmin");
	//²Ù×÷
	webtest.click("xpath=//a[contains(text(),'·¢ÐÅ')]");
	webtest.click("xpath=//input[@id='turnon0']");
	webtest.type("id=fromAddress", "m567891@163.com");
	webtest.click("xpath=//button[@id='submit']");
	webtest.type("password", "123456");
	webtest.click("xpath=//button[@id='submit']");
	//Ç©ÍË
	webtest.leaveFrame();
	webtest.click("xpath=//a[contains(text(),'Ç©ÍË')]");
	}
}
