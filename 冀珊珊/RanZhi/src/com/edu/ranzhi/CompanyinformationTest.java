package com.edu.ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(WebTestListener.class)
public class CompanyinformationTest extends BaseTest{
	@Test
	public void testManage() throws InterruptedException{
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account","admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=//*[contains(text(),'��˾��Ϣ')]");
		webtest.typeAndClear("name=name","Ȼ֮");
//		���ı��������ַ�ʽ��1��ֱ��tab2��enterframe����������int����frame�����������ߣ���id�����֣�����Ҳ����xpath��������װ���������ַ���
		webtest.tapClick();
//		webtest.enterFrame("ke-edit-iframe");
//		webtest.enterFrame(0);
//		ֱ����body�������붫��
		webtest.type("tag=body", "hellohello");
		webtest.tapClick();
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[contains(text(),'ǩ��')]");
	}
}
           