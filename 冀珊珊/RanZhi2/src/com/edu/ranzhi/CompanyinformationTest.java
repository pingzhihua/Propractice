package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

import org.testng.annotations.Test;

//@Listeners(WebTestListener.class)
public class CompanyinformationTest extends BaseTest {
	@Test(dataProvider = "companyData", dataProviderClass = NSDataProvider.class)
	public void testCompany(String name, String body) throws InterruptedException {

		webtest.click("xpath=//*[contains(text(),'��˾��Ϣ')]");
		webtest.typeAndClear("name=name", name);
		// ���ı��������ַ�ʽ��1��ֱ��tab2��enterframe����������int����frame�����������ߣ���id�����֣�����Ҳ����xpath��������װ���������ַ���
		webtest.tapClick();
		// webtest.enterFrame("ke-edit-iframe");
		// webtest.enterFrame(0);
		// ֱ����body�������붫��
		webtest.type("tag=body", body);
		webtest.tapClick();
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='close-win']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
	}
}
