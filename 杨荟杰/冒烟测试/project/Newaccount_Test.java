package com.webtest.project;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Newaccount_Test extends BaseTest{
	
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/data.xlsx","Sheet2");
	}
	
	@Test(dataProvider="movie")
	public void newaccount(String a,String b) throws InterruptedException{

		//账户
		webtest.click("link=账户");
		//新建账户
		webtest.click("link=添加账号");
		webtest.type("xpath=//select[@id='type']","现金账号");
		webtest.type("xpath=//input[@id='abbr']",a);
		webtest.type("xpath=//input[@id='tags']",b);
		webtest.type("xpath=//select[@id='currency']","美元");
		//保存
		webtest.click("xpath=//button[@id='submit']");
//		webtest.leaveFrame();
//		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));


	}

}
