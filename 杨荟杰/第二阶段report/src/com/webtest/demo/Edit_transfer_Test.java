package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Edit_transfer_Test extends BaseTest{
	@Test
	public void edittranser() throws InterruptedException{
		//登录
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//现金记账 
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//转账
		webtest.click("link=转账");
//		webtest.click("link=编辑");
		//选择编辑
//		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer]");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer");
		//修改
		webtest.type("xpath=//input[@id='money']","2000");
		//保存
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));
	}

}
