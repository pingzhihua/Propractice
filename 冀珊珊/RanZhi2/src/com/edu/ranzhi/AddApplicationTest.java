package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class AddApplicationTest extends BaseTest {

	@Test(dataProvider = "applicationData", dataProviderClass = NSDataProvider.class)
	public void testApplication(String name, String abbr, String code, String url) throws InterruptedException {

		webtest.click("xpath=//*[contains(text(),'���Ӧ��')]");
		// webtest.click("xpath=//a[@href]");

		webtest.type("name=name", name);
		webtest.type("name=abbr", abbr);
		webtest.type("name=code", code);
		webtest.type("name=login", url);

		// ת��js���޸Ĳ��ɼ����ԣ������ҵ�Ԫ�أ���Ԫ�ر�Ϊ�ɼ���Ȼ���������id����value����Ԫ�أ����Ƽ���class������ܶ࣬style�е�����Ҫ����ҳ��ʽһ�����ͱ���style�����"=",display����ġ�������
		// index��0��ʼ�㣬���ܵ����Ŀ�����������select�ĸ���������select�ı�ǩ����ǩ��Ļ���getElemetsBy...,��Ϊ���Ƶ�[0]�������л�Ҫ�����������ڼ�����
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 1);

		webtest.click("xpath=//input[@id='groups1']");
		webtest.click("xpath=//input[@id='groups7']");
		webtest.click("xpath=//input[@id='platformranzhi']");
		webtest.click("xpath=//button[@id='submit']");

	}
}
