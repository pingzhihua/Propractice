package com.webtest.project;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;

@Listeners(WebTestListener.class)

public class Admin_Login  extends BaseTest{
	
//	@Test
//	public void testLoginSuccess() {
//		//打开页面
//		webtest.open("http://localhost/ranzhi/www/sys/");
//		//文本框输入
//		webtest.type("name=account", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("退出"));
//	}
//	
//	@Test
//	public void testLoginfail() {
//		webtest.open("http://localhost/ranzhi/www/sys/");
//		webtest.type("name=account", "admin");
//		webtest.type("name=password", "1234567");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("退出"));
//	}

	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/data.xlsx","Sheet1");
	}

	@Test(dataProvider="movie")
	
	public void testmoney(String a,String b) throws InterruptedException{
		//收入
		webtest.click("link=收入");
		webtest.click("link=记收入");
		//新建收入****
		//账号
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",2);
		//产品
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product",2);
		//科目
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category",2);
    	//客户
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader",2);

		webtest.type("xpath=//input[@id='money']", a);
		//部门
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",3);
		//经手人
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",1);
		//交易时间
		webtest.typeAndClear("xpath=//input[@id='date']","2019-11-10");
		webtest.clickLonger("xpath=//input[@id='date']");
		//说明
		webtest.type("xpath=//textarea[@id='desc']",b);
		//保存
		webtest.click("xpath=//button[@id='submit']");
//		webtest.leaveFrame();
//		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));

	}
	

}
