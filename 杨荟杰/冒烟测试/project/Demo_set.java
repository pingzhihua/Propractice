package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_set extends BaseTest{
	@Test
	public void demo07(){
		webtest.click("link=设置");
		webtest.type("xpath=//input[@name='children[3]']","副业收入");
		webtest.type("xpath=//input[@name='children[4]']","子公司收入");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test
	public void demo08(){
		webtest.click("link=设置");
		webtest.click("link=支出科目");
		webtest.type("xpath=//input[@name='children[3]']","项目失败支出");
		webtest.type("xpath=//input[@name='children[4]']","子公司支出");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo09(){
		webtest.click("link=设置");
		webtest.click("link=货币类型");
		webtest.click("xpath=//input[@value='thb']");
		webtest.click("xpath=//input[@value='sur']");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo10(){
		webtest.click("link=设置");
		webtest.click("link=记账设置");
		webtest.click("xpath=//input[@name='trader']");
		webtest.click("xpath=//input[@name='product']");
		webtest.click("xpath=//button[@id='submit']");
	}


}
