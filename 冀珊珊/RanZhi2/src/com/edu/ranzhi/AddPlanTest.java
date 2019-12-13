package com.edu.ranzhi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddPlanTest extends BaseTest {
	@BeforeClass
	public void doBefore() throws Exception {
		// ��¼
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void testplan() {

		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		// ����
		webtest.click("xpath=//a[contains(text(),'�ƻ�����')]");
		webtest.click("xpath=//a[contains(text(),'���')]");
		webtest.type("name=m", "20");
		webtest.type("name=h", "1");
		webtest.type("name=dom", "1");
		webtest.type("name=mon", "2");
		webtest.type("name=dow", "6");
		webtest.type("name=command", "С����");
		webtest.selectByIndex("id=type", 0);
		webtest.click("xpath=//button[@id='submit']");
		// ǩ��
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
