package com.webtest.project;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Edit_transfer_Test extends BaseTest{
	@Test
	public void edittranser() throws InterruptedException{
		//转账
		webtest.click("link=转账");
		//选择编辑
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer");

		webtest.type("xpath=//textarea[@id='desc']","xinde!!!!!!!!!!");
		//保存
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));
	}
	@Test
	public void demo30(){
		webtest.click("link=转账");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=detail&tradeID=13&mode=transfer");
		webtest.type("xpath=//input[@id='money[0]']","555");
		webtest.type("xpath=//textarea[@id='desc[0]']","给供应商投资");
		webtest.click("xpath=//button[@id='submit']");
	}
	

}
