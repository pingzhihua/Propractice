package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import org.testng.annotations.Test;

public class RestartXuanXuan extends BaseTest {
	@Test
	public void testXuanxuan() throws Exception {
		// ����
		webtest.click("xpath=//*[contains(text(),'����')]");
		webtest.click("xpath=//*[contains(text(),'����������Կ')]");
		webtest.click("xpath=//button[@id='submit']");
	}
}
