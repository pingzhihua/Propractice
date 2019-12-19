package com.edu.ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class MaintenanceDepartmentTest extends BaseTest {
	@Test
	public void testMD() {

		// ����
		webtest.click("xpath=//a[contains(text(),'��֯')]");
		webtest.click("xpath=//a[contains(text(),'ά������')]");
		webtest.typeAndClear("name=children[20]", "������");
		webtest.typeAndClear("name=children[21]", "�⽻��");
		webtest.click("xpath=//button[@id='submit']");
		
		assertTrue(webtest.isTextPresent("�⽻��"));
	}
}
