package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_jiedai extends BaseTest{
	@Test
	public void demo25(){
		webtest.click("link=½è´û");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=view&tradeID=25&mode=loan");
		webtest.click("xpath=//a[@id='backButton']");
	}
	@Test
	public void demo26(){
		webtest.click("link=½è´û");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=detail&tradeID=23&mode=loan");
		webtest.type("xpath=//input[@id='money[0]']","444");
		webtest.type("xpath=//textarea[@id='desc[0]']", "ÕâÀïÊÇËµÃ÷");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo27(){
		webtest.click("link=½è´û");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=24&mode=loan");
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader",4);
		webtest.type("xpath=//textarea[@id='desc']","½è´û");
		webtest.click("xpath=//a[@id='backButton']");
	}
	@Test
	public void demo28(){
		webtest.click("link=½è´û");
		webtest.click("link=ËÑË÷");
		webtest.runJs("document.getElementById('value1').style='display:block'");
		webtest.selectByIndex("id=value1",4);
		webtest.runJs("document.getElementById('value4').style='display:block'");
		webtest.selectByIndex("id=value4",3);
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo29(){
		webtest.click("link=½è´û");
		webtest.click("link=»¹´û");
		webtest.selectByIndex("id=depositor",4);
		webtest.selectByIndex("id=loanID",2);
		webtest.type("xpath=//input[@id='money']","3000");
		webtest.type("xpath=//input[@id='interest']","300");	
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",4);
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",4);
		webtest.type("xpath=//textarea[@id='desc']","ÕâÊÇ»¹´û");
		webtest.click("xpath=//a[@id='backButton']");
	}
	
	
	

	

}
