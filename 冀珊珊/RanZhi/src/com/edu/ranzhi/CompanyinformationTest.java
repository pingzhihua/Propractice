package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(WebTestListener.class)
public class CompanyinformationTest extends BaseTest{
	@Test
	public void testManage() throws InterruptedException{
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account","admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=//*[contains(text(),'公司信息')]");
		webtest.typeAndClear("name=name","然之");
//		进文本框有三种方式：1、直接tab2、enterframe方法可以用int（即frame个数），或者，用id，名字，或者也可用xpath，即：封装重载了三种方法
		webtest.tapClick();
//		webtest.enterFrame("ke-edit-iframe");
//		webtest.enterFrame(0);
//		直接在body里面输入东西
		webtest.type("tag=body", "hellohello");
		webtest.tapClick();
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[contains(text(),'签退')]");
	}
}
           