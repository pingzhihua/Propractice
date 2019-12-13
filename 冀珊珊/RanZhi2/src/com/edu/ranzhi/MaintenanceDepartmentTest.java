package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class MaintenanceDepartmentTest extends BaseTest {
	@BeforeClass
	public void doBefore() throws Exception {
		// ��¼
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void testMD() {
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		// ����
		webtest.click("xpath=//a[contains(text(),'��֯')]");
		webtest.click("xpath=//a[contains(text(),'ά������')]");
		webtest.typeAndClear("name=children[20]", "������");
		webtest.typeAndClear("name=children[21]", "�⽻��");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("�⽻��"));
		// ǩ��
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
