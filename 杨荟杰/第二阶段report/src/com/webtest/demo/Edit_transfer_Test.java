package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Edit_transfer_Test extends BaseTest{
	@Test
	public void edittranser() throws InterruptedException{
		//��¼
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//�ֽ���� 
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//ת��
		webtest.click("link=ת��");
//		webtest.click("link=�༭");
		//ѡ��༭
//		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer]");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer");
		//�޸�
		webtest.type("xpath=//input[@id='money']","2000");
		//����
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));
	}

}
