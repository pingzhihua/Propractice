package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_set extends BaseTest{
	@Test
	public void demo07(){
		webtest.click("link=����");
		webtest.type("xpath=//input[@name='children[3]']","��ҵ����");
		webtest.type("xpath=//input[@name='children[4]']","�ӹ�˾����");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test
	public void demo08(){
		webtest.click("link=����");
		webtest.click("link=֧����Ŀ");
		webtest.type("xpath=//input[@name='children[3]']","��Ŀʧ��֧��");
		webtest.type("xpath=//input[@name='children[4]']","�ӹ�˾֧��");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo09(){
		webtest.click("link=����");
		webtest.click("link=��������");
		webtest.click("xpath=//input[@value='thb']");
		webtest.click("xpath=//input[@value='sur']");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo10(){
		webtest.click("link=����");
		webtest.click("link=��������");
		webtest.click("xpath=//input[@name='trader']");
		webtest.click("xpath=//input[@name='product']");
		webtest.click("xpath=//button[@id='submit']");
	}


}
