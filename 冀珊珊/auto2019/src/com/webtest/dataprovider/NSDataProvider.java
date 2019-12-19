package com.webtest.dataprovider;

import org.testng.annotations.DataProvider;

public class NSDataProvider {

	@DataProvider(name="groupData")
	public  static Object[][] getTxtData1() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/groupdata.txt");
	}
	@DataProvider(name="applicationData")
	public  static Object[][] getTxtData2() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/applicationdata.txt");
	}
	@DataProvider(name="memberData")
	public  static Object[][] getTxtData3() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/memberdata.txt");
	}
	@DataProvider(name="planData")
	public  static Object[][] getTxtData4() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/plandata.txt");
	}
	@DataProvider(name="backupData")
	public  static Object[][] getTxtData5() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/backupata.txt");
	}
	@DataProvider(name="companyData")
	public  static Object[][] getTxtData6() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/companydata.txt");
	}@DataProvider(name="sendingData")
	public  static Object[][] getTxtData7() throws Exception{
		new  TxtDataProvider();
		return TxtDataProvider.getTestData("data/sendingdata.txt");
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
