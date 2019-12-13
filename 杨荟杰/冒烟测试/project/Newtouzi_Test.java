package com.webtest.project;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Newtouzi_Test extends BaseTest{
	
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/data.xlsx","Sheet2");
	}
	@Test(dataProvider="movie")
	public void touzi(String a,String b){
		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=browse&mode=invest]");
		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=invest&type=invest]");
//		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=browse&mode=invest]");
//		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=invest&type=invest]");

//		webtest.click("xpath=//select[@id='depositor']");
//		webtest.click("xpath=//option[@value='2']");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor",2);
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader",4);
		webtest.type("xpath=//input[@id='money']", a);		
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept",3);		
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers",1);
		webtest.typeAndClear("xpath=//input[@id='deadline']","2019-11-10");
		webtest.clickLonger("xpath=//input[@id='deadline']");
		webtest.type("xpath=//textarea[@id='desc']",b);
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=Ç©ÍË");
		assertTrue(webtest.isTextPresent("ÍË³ö"));
	}

}
