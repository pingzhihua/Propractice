package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class RestartXuanXuan extends BaseTest{
	@BeforeClass
	public void doBefore() throws Exception {
		// ��¼
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
	}
@Test
	public void testXuanxuan() throws Exception{
	//����
	webtest.click("xpath=//button[@data-id='superadmin']");
	webtest.enterFrame("iframe-superadmin");
	webtest.click("xpath=//*[contains(text(),'����')]");
	webtest.click("xpath=//*[contains(text(),'����������Կ')]");
	webtest.click("xpath=//button[@id='submit']");
//	webtest.leaveFrame();
//	//ǩ��
//	webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
