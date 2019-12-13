package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demoshouru extends BaseTest{
	@Test
	public void demo05(){
		webtest.click("link=收入");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@id='submit']");
		webtest.type("xpath=//input[@id='money6']","60000");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo06(){
		webtest.click("link=收入");
		webtest.click("xpath=//input[@value='28']");
		webtest.click("xpath=//input[@value='30']");
		webtest.click("xpath=//a[@id='reversechecker']");
	}
	
}
