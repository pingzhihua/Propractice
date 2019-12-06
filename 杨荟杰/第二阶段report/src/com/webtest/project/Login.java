package com.webtest.project;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Login extends BaseTest{
	@Test
	public void testLogin() throws InterruptedException{
		//��ҳ��
		webtest.open("http://localhost/ranzhi/www/sys/");
		//�ı��������¼
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		assertTrue(webtest.isTextPresent("�˳�"));
		
	}

}
