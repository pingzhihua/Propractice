package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_baobiao extends BaseTest{
	@Test
	public void demo19(){
		webtest.click("link=����");
		webtest.click("link=�����");
		webtest.click("link=��Ԫ");
		webtest.click("link=ǧԪ");
		webtest.click("link=��Ԫ");
	}
	@Test
	public void demo20(){
		webtest.click("link=����");
		webtest.click("link=��ȶԱȱ�");
		webtest.selectByIndex("id=currency",2);
		webtest.selectByIndex("id=unit",3);
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo21(){
		webtest.click("link=����");
		webtest.click("link=�˺�ӯ����");
		webtest.type("id=fileName","2019�˺�ӯ����");
		webtest.click("xpath=//option[@value=xlsx]");
		webtest.click("xpath=//button[@id='submit']");	
	}
	@Test
	public void demo22(){
		webtest.click("link=����");
		webtest.click("link=����λ");
		webtest.selectByIndex("id=unit",3);
		webtest.click("xpath=//button[@id='submit']");	
	}

}
