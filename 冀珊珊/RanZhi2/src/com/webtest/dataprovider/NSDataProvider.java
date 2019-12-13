package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	@DataProvider(name="groupData")
	public  static Object[][] getTxtData1() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/groupdata.txt");
	}
	@DataProvider(name="applicationData")
	public  static Object[][] getTxtData2() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTxtUser("data/applicationdata.txt");
	}
//	@DataProvider(name="txt")
//	public  Object[][] getTxtData1() throws IOException{
//		return new  TxtDataProvider().getTestData("data/user.txt");
//	}
//	@DataProvider(name="movie")
//	public  Object[][] getMovieData() throws IOException{
//		return new  ExcelDataProvider().getTestDataByExcel("data/movie.xlxs","Sheet1");
//	}
//	@Test(dataProvider="txt")
//	public void getData(String a,String b) {
//		System.out.println(a+" "+b);
//		
//	}
//
//	@DataProvider(name="excel")
//	public Object[][] getExcelDada() throws IOException{
//		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
//	}
//	
//	@DataProvider(name="mysql")
//	public Object[][] getMysqlDada() throws IOException{
//		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
//				"FROM `mm_movie` ");
//	}
//	
//	@Test(dataProvider="mysql")
//	public void testDB(String a,String b) {
//		System.out.println(a+" "+b);
//	}
	
}
