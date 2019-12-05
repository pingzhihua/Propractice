package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class RestartXuanXuan extends BaseTest{
@Test
	public void testXuanxuan() throws Exception{
	//µÇÂ¼
	webtest.open("http://localhost/ranzhi/www");
	webtest.type("name=account","admin");
	webtest.type("name=password", "123456");
	webtest.click("xpath=//button[@id='submit']");
	//²Ù×÷
	webtest.click("xpath=//button[@data-id='superadmin']");
	webtest.enterFrame("iframe-superadmin");
	webtest.click("xpath=//*[contains(text(),'ĞúĞú')]");
	webtest.click("xpath=//*[contains(text(),'ÖØĞÂÉú³ÉÃÜÔ¿')]");
	webtest.click("xpath=//button[@id='submit']");
	webtest.leaveFrame();
	//Ç©ÍË
	webtest.click("xpath=//a[contains(text(),'Ç©ÍË')]");
	}
}
