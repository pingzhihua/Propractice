
package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class AddMembersTest extends BaseTest {
	@Test(dataProvider = "memberData", dataProviderClass = NSDataProvider.class)
	public void testMember(String name, String realname,String password1,String password2,String email) throws Exception {

		webtest.click("xpath=//*[contains(text(),'ÃÌº”≥…‘±')]");
		webtest.click("name=account");
		webtest.type("name=account", name);
		webtest.type("name=realname", realname);
		webtest.click("xpath=//input[@id='genderf']");
		webtest.click("xpath=//option[@value='21']");
		webtest.click("xpath=//option[@value='pm']");
		webtest.type("name=password1", password1);
		webtest.type("name=password2", password2);
		webtest.type("name=email", email);
		webtest.click("xpath=//button[@id='submit']");

	}

}
