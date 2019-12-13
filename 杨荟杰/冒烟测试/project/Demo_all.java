package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_all extends BaseTest{
	
	@Test(description="搜索")
	public void demo01(){ 
		webtest.click("link=所有");
		webtest.click("xpath=//a[href=/ranzhi/www/cash/index.php?m=trade&f=browse&mode=all&date=201912]");
		webtest.click("link=搜索");		
	}
	@Test(description="搜索")
	public void demo02(){
		webtest.click("link=所有");
		webtest.click("link=搜索");
		webtest.runJs("document.getElementById('value1').style='display:block'");
		webtest.selectByIndex("id=value1",3);
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test(description="批量记账")
	public void demo03(){
		webtest.click("link=所有");
		webtest.click("link=批量记账");
		webtest.runJs("document.getElementById('depositor0').style='display:block'");
		webtest.selectByIndex("id=depositor0",6);
		webtest.runJs("document.getElementById('category0').style='display:block'");
		webtest.selectByIndex("id=category0",2);
		webtest.type("xpath=//input[@id='money[0]']","999");
		webtest.runJs("document.getElementById('handlers0').style='display:block'");
		webtest.selectByIndex("id=handlers0",1);
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo04(){
		webtest.click("link=所有");
		webtest.click("xpath=//a[@id='_recPerPage']");
		webtest.click("xpath=//a[@id='javascript:submitPage('changeRecPerPage', 10)']");
	}
	
	
	

	
	
	
}
