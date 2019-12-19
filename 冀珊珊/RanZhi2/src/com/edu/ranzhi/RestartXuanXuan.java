package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import org.testng.annotations.Test;

public class RestartXuanXuan extends BaseTest {
	@Test
	public void testXuanxuan() throws Exception {
		// 操作
		webtest.click("xpath=//*[contains(text(),'喧喧')]");
		webtest.click("xpath=//*[contains(text(),'重新生成密钥')]");
		webtest.click("xpath=//button[@id='submit']");
	}
}
