package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class BackUpTest extends BaseTest{
	@Test
	public void testBackUp(){
		// 登录
				webtest.open("http://localhost/ranzhi/www");
				webtest.type("name=account", "admin");
				webtest.type("name=password", "123456");
				webtest.click("xpath=//button[@id='submit']");
				webtest.click("xpath=//button[@data-id='superadmin']");
				webtest.enterFrame("iframe-superadmin");
				// 操作
				webtest.click("xpath=//a[contains(text(),'备份')]");
				webtest.click("xpath=//a[contains(text(),'设置保存天数')]");
				webtest.typeAndClear("id=saveDays", "99");
				webtest.click("xpath=//button[@id='submit']");
				webtest.click("xpath=//*[@class='btn btn-primary backup']");
				webtest.click("xpath=//button[@class='btn btn-primary']");
				
				webtest.leaveFrame();
				webtest.click("xpath=//a[contains(text(),'签退')]");	
	}
}
