package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_baobiao extends BaseTest{
	@Test
	public void demo19(){
		webtest.click("link=报表");
		webtest.click("link=人民币");
		webtest.click("link=美元");
		webtest.click("link=千元");
		webtest.click("link=万元");
	}
	@Test
	public void demo20(){
		webtest.click("link=报表");
		webtest.click("link=年度对比表");
		webtest.selectByIndex("id=currency",2);
		webtest.selectByIndex("id=unit",3);
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo21(){
		webtest.click("link=报表");
		webtest.click("link=账号盈亏表");
		webtest.type("id=fileName","2019账号盈亏表");
		webtest.click("xpath=//option[@value=xlsx]");
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo22(){
		webtest.click("link=报表");
		webtest.click("link=报表单位");
		webtest.selectByIndex("id=unit",3);
		webtest.click("xpath=//button[@id='submit']");	
	}

}
