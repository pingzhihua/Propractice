package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class SendingSettingsTest extends BaseTest {
	@Override
	public void doBeforeClass() throws Exception {

		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		
	}
	@Test
	public void testXuanxuan() throws Exception {
		
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		// ����
		webtest.click("xpath=//a[contains(text(),'����')]");
		webtest.click("xpath=//input[@id='turnon0']");
		webtest.type("id=fromAddress", "m567891@163.com");
		webtest.click("xpath=//button[@id='submit']");
		webtest.type("password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("�ɹ�"));
		// ǩ��
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
