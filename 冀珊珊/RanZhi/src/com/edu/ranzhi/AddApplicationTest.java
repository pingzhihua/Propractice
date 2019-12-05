package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddApplicationTest extends BaseTest {
	@Test
	public void testManage() throws InterruptedException {
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=//*[contains(text(),'���Ӧ��')]");
		webtest.click("xpath=//a[@href]");

		webtest.type("name=name", "����");
		webtest.type("name=abbr", "SQ");
		webtest.type("name=code", "shequ");
		webtest.type("name=login", "http://www.baidu.com");

		// ת��js���޸Ĳ��ɼ����ԣ������ҵ�Ԫ�أ���Ԫ�ر�Ϊ�ɼ���Ȼ���������id����value����Ԫ�أ����Ƽ���class������ܶ࣬style�е�����Ҫ����ҳ��ʽһ�����ͱ���style�����"=",display����ġ�������
		// index��0��ʼ�㣬���ܵ����Ŀ�����������select�ĸ���������select�ı�ǩ����ǩ��Ļ���getElemetsBy...,��Ϊ���Ƶ�[0]�������л�Ҫ�����������ڼ�����
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 2);

		webtest.click("xpath=//input[@id='groups1']");
		webtest.click("xpath=//input[@id='groups7']");
		webtest.click("xpath=//input[@id='platformranzhi']");
		webtest.click("xpath=//button[@id='submit']");

		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
