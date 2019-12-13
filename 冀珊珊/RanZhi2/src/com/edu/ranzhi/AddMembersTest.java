
package com.edu.ranzhi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddMembersTest extends BaseTest {
	@Test
	public void testManage() throws InterruptedException {
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=//*[contains(text(),'ÃÌº”≥…‘±')]");
		webtest.click("name=account");
		webtest.type("name=account", "yangyangyan");
		webtest.type("name=realname", "yangyangyan");
		webtest.click("xpath=//input[@id='genderf']");
		webtest.click("xpath=//option[@value='21']");
		webtest.click("xpath=//option[@value='pm']");
		webtest.type("name=password1", "123456");
		webtest.type("name=password2", "123456");
		webtest.type("name=email", "1234563@163.com");
		webtest.click("xpath=//button[@id='submit']");
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[contains(text(),'«©ÕÀ')]");
	}

}
