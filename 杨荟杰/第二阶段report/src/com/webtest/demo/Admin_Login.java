package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.MailUtil;

@Listeners(WebTestListener.class)

public class Admin_Login  extends BaseTest{
	
//	@Test
//	public void testLoginSuccess() {
//		//��ҳ��
//		webtest.open("http://localhost/ranzhi/www/sys/");
//		//�ı�������
//		webtest.type("name=account", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("�˳�"));
//	}
//	
//	@Test
//	public void testLoginfail() {
//		webtest.open("http://localhost/ranzhi/www/sys/");
//		webtest.type("name=account", "admin");
//		webtest.type("name=password", "1234567");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("�˳�"));
//	}
	
	@Test
	public void testmoney() throws InterruptedException{
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
		webtest.click("link=������");
		//�½�����****
		//�˺�
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",2);
		//��Ʒ
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product",2);
		//��Ŀ
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category",2);
    	//�ͻ�
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader",2);
		//��ͬ
		webtest.runJs("document.getElementById('contract').style='display:block'");
		webtest.selectByIndex("id=contract",1);
        //���
//		webtest.type("xpath=//input[@id='money']", "20000");		
		//����
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",3);
		//������
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",1);
		//����ʱ��
		webtest.typeAndClear("xpath=//input[@id='date']","2019-11-10");
		webtest.clickLonger("xpath=//input[@id='date']");
		//˵��
		webtest.type("xpath=//textarea[@id='desc']","2222222");
		//����
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));


		
		
	}

	
}
