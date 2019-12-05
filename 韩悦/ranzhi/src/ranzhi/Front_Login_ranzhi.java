package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


public class Front_Login_ranzhi extends BaseTest{
Login_ranzhi action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_ranzhi(webtest); 
		
	}
	@Test(priority=0)
	public void testLogin() throws Exception  {		
		webtest.open("http://localhost/ranzhi/www/sys");
		action.login();
		assertTrue(webtest.isTextPresent("Ç©ÍË"));
	}
	@Test(priority=1)
	public void test1() throws Exception  {
		webtest.click("xpath=//*[@id='s-menu-1']/button/img");
		Thread.sleep(2000);
		webtest.click("link=¶©µ¥");
//		webtest.click("xpath=//*[@id='mainNavbar']/ul/li[1]/a");
	}
	}
