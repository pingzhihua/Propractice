package com.webtest.project;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Checkaccount_Test extends BaseTest{
	@Test
	public void checkaccount() throws InterruptedException{
		//对账
		webtest.click("link=对账");
		//筛选条件
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",3);
		webtest.type("xpath=//select[@id='start']","2019-12-01");
		webtest.type("xpath=//select[@id='end']","2019-12-03");
		//对账
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@id='submit']");
//		webtest.leaveFrame();
//		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));
	}
	

}
