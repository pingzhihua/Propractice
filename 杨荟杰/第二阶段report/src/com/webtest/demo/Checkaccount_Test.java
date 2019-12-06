package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Checkaccount_Test extends BaseTest{
	@Test
	public void checkaccount() throws InterruptedException{
		//��¼
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//�ֽ����
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//����
		webtest.click("link=����");
		//ɸѡ����
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",3);
		webtest.type("xpath=//select[@id='start']","2019-12-01");
		webtest.type("xpath=//select[@id='end']","2019-12-03");
		//����
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));
	}
	

}
