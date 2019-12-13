package com.edu.ranzhi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class BackUpTest extends BaseTest {
	@BeforeClass
	public void doBefore() throws Exception {
		// ��¼
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void testBackUp() {

		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		// ����
		webtest.click("xpath=//a[contains(text(),'����')]");
		webtest.click("xpath=//a[contains(text(),'���ñ�������')]");
		webtest.typeAndClear("id=saveDays", "99");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//*[@class='btn btn-primary backup']");
		webtest.click("xpath=//button[@class='btn btn-primary']");

//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
