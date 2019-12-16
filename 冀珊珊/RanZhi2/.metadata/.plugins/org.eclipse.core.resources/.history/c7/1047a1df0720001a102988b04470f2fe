package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(WebTestListener.class)
public class LoginTest extends BaseTest{
	
	@Test
	public void testGetLoginfail() throws InterruptedException {
		webtest.leaveFrame();
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account","admin");
		webtest.type("name=password", "admins");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("Ç©ÍË"));

	}
	@Test
	public void testGetLogin() throws InterruptedException {
		webtest.leaveFrame();
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account","admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("Ç©ÍË"));
		
	}
	
}
           