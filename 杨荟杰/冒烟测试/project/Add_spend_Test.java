package com.webtest.project;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Add_spend_Test extends BaseTest{
	
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/data.xlsx","Sheet3");
	}
	@Test(dataProvider="movie")
	public void addspend(String a,String b) throws InterruptedException{
		//支出
		webtest.click("link=支出");
		webtest.click("link=记支出");
		//新建支出**
		//账号
//		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",4);
		//产品
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product",1);
		//科目
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category",3);
		//类型
		webtest.click("xpath=//input[@id='objectTypecustomer']");
		//客户
		webtest.runJs("document.getElementById('customer').style='display:block'");
		webtest.selectByIndex("id=customer",1);
		//金额
		webtest.type("xpath=//input[@id='money']",a);
		webtest.type("xpath=//input[@id='exchangeRate']",b);
		//部门
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",5);
		//经手人
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",3);
		webtest.selectByIndex("id=handlers",3);
		//交易时间
		webtest.typeAndClear("xpath=//input[@id='date']","2019-11-10");
		webtest.clickLonger("xpath=//input[@id='date']");
		//说明
		webtest.type("xpath=//textarea[@id='desc']","2222222");
		//保存
		webtest.click("xpath=//button[@id='submit']");	
//		Thread.sleep(4000);
//		webtest.leaveFrame();
//		webtest.click("link=签退");
		assertTrue(webtest.isTextPresent("退出"));
	}

}
