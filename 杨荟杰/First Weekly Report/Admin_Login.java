package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

@Listeners(WebTestListener.class)

public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin() {
		//��ҳ��
		webtest.open("http://localhost:8032/mymovie/admin.php/");
		//�ı�������
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test
	public void testLoginfail() {
		webtest.open("http://localhost:8032/mymovie/admin.php/");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�˳�"));
	}

}
