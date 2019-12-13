package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_duizhang extends BaseTest{
	@Test
	public void demo23(){
		webtest.click("link=╤тук");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",5);
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo24(){
		webtest.click("link=╤тук");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",1);
		webtest.type("xpath=//select[@id='end']","2019-12-03");
		webtest.click("xpath=//button[@id='submit']");
	}

}
