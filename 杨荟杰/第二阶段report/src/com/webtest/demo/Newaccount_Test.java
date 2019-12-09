package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Newaccount_Test extends BaseTest{
	@Test
	public void newaccount() throws InterruptedException{
		//登录
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//现金记账
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//账户
		webtest.click("link=账户");
		//新建账户
		webtest.click("link=添加账号");
		webtest.type("xpath=//select[@id='type']","现金账号");
		webtest.type("xpath=//input[@id='abbr']","老樊");
		webtest.type("xpath=//input[@id='tags']","xx专用");
		webtest.type("xpath=//select[@id='currency']","美元");
		//保存
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));


	}

}
