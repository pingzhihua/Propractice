package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_zhanghu extends BaseTest{
	@Test
	public void demo14(){
		webtest.click("link=�˻�");
		webtest.click("link=xxר��");
		webtest.click("link=55");
		webtest.click("link=�����˺�");
	}
	@Test
	public void demo15(){
		webtest.click("link=�˻�");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=balance&f=browse&depositorID=3");
	}
	@Test
	public void demo16(){
		webtest.click("link=�˻�");
		webtest.click("link=�����˺�");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=activate&depositorID=5");
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo17(){
		webtest.click("link=�˻�");
		webtest.click("link=xxר��");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=forbid&depositorID=10");
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo18(){
		webtest.click("link=�˻�");
		webtest.click("link=55");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=edit&depositorID=13");
		webtest.type("xpath=//input[@id='tags']","�����Ǳ�ע");
		webtest.click("xpath=//button[@id='submit']");	
	}
	
	
	

}
