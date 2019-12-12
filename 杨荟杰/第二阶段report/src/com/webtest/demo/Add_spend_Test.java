package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Add_spend_Test extends BaseTest{
	@Test
	public void addspend() throws InterruptedException{
		//��¼
		webtest.open("http://localhost/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		//�ֽ����
		webtest.click("xpath=//button[@data-id='5']");
		webtest.enterFrame("iframe-5");
		//֧��
		webtest.click("link=֧��");
		webtest.click("link=��֧��");
		//�½�֧��**
		//�˺�
//		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",4);
		//��Ʒ
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product",1);
		//��Ŀ
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category",3);
		//����
		webtest.click("xpath=//input[@id='objectTypecustomer']");
		//�ͻ�
		webtest.runJs("document.getElementById('customer').style='display:block'");
		webtest.selectByIndex("id=customer",1);
		//���
		webtest.type("xpath=//input[@id='money']", "20000");
		webtest.type("xpath=//input[@id='exchangeRate']", "0.3");
		//����
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",5);
		//������
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",3);
		webtest.selectByIndex("id=handlers",3);
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
