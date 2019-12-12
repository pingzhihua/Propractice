package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Newaccount_Test extends BaseTest{
	@Test
	public void newaccount() throws InterruptedException{
		//��¼
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//�ֽ����
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//�˻�
		webtest.click("link=�˻�");
		//�½��˻�
		webtest.click("link=����˺�");
		webtest.type("xpath=//select[@id='type']","�ֽ��˺�");
		webtest.type("xpath=//input[@id='abbr']","�Ϸ�");
		webtest.type("xpath=//input[@id='tags']","xxר��");
		webtest.type("xpath=//select[@id='currency']","��Ԫ");
		//����
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));


	}

}
