package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

@Listeners(WebTestListener.class)
public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLoginSuccess() {
		//��ҳ��
		webtest.open("http://localhost:80/ranzhi/www/sys/");
		//�ı�������
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@type='submit']");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	
	@Test
	public void testLoginFail(){
		webtest.open("http://localhost:80/ranzhi/www/sys/");
		//�ı�������
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�˳�"));
	}

}
