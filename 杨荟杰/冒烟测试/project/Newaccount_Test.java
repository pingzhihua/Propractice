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

		//�˻�
		webtest.click("link=�˻�");
		//�½��˻�
		webtest.click("link=����˺�");
		webtest.type("xpath=//select[@id='type']","�ֽ��˺�");
		webtest.type("xpath=//input[@id='abbr']",a);
		webtest.type("xpath=//input[@id='tags']",b);
		webtest.type("xpath=//select[@id='currency']","��Ԫ");
		//����
		webtest.click("xpath=//button[@id='submit']");
//		webtest.leaveFrame();
//		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));


	}

}
