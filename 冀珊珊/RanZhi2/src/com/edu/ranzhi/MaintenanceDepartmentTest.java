package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class MaintenanceDepartmentTest extends BaseTest {
	@BeforeClass
	public void doBefore() throws Exception {
		// 登录
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void testMD() {
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		// 操作
		webtest.click("xpath=//a[contains(text(),'组织')]");
		webtest.click("xpath=//a[contains(text(),'维护部门')]");
		webtest.typeAndClear("name=children[20]", "交流部");
		webtest.typeAndClear("name=children[21]", "外交部");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("外交部"));
		// 签退
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'签退')]");
	}
}
