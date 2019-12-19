package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class MaintenanceDepartmentTest extends BaseTest {
	@Test
	public void testMD() {

		// 操作
		webtest.click("xpath=//a[contains(text(),'组织')]");
		webtest.click("xpath=//a[contains(text(),'维护部门')]");
		webtest.typeAndClear("name=children[20]", "交流部");
		webtest.typeAndClear("name=children[21]", "外交部");
		webtest.click("xpath=//button[@id='submit']");
		
		assertTrue(webtest.isTextPresent("外交部"));
	}
}
