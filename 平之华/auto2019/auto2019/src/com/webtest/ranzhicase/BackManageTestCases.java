/*
 * author 冀珊珊
 * session 后台管理
 * caseSuccess 40
 * caseFail    6
 */

package com.webtest.ranzhicase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.demo.Login_Action;

@Listeners
public class BackManageTestCases extends BaseTest {
	@BeforeClass
	public void login(){
		webtest.open("http://localhost:80/ranzhi/www/sys/");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
	}
	
	@DataProvider(name="applicationData")
	public  static Object[][] getTxtData2() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/applicationdata.txt");
	}
	
	@Test(dataProvider = "applicationData")
	public void testApplication(String name, String abbr, String code, String url) throws InterruptedException {
		webtest.click("xpath=//*[contains(text(),'添加应用')]");
		webtest.type("name=name", name);
		webtest.type("name=abbr", abbr);
		webtest.type("name=code", code);
		webtest.type("name=login", url);
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 1);
		webtest.click("xpath=//input[@id='groups1']");
		webtest.click("xpath=//input[@id='groups7']");
		webtest.click("xpath=//input[@id='platformranzhi']");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@DataProvider(name="groupData")
	public  static Object[][] getTxtData1() throws Exception{
		return  new TxtDataProvider().getTestData("dataProvider/groupdata.txt");
	}

	@Test(dataProvider = "groupData")
	public void testAddGroup(String name, String desc) {
		// 操作
		webtest.click("xpath=//a[contains(text(),'权限')]");
		webtest.click("xpath=//a[contains(text(),'新增分组')]");
		webtest.type("name=name", name);
		webtest.type("name=desc", desc);
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@DataProvider(name="memberData")
	public  static Object[][] getTxtData3() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/memberdata.txt");
	}

	@Test(dataProvider = "memberData")
	public void testMember(String name, String realname, String password1, String password2, String email)
			throws Exception {
		webtest.click("xpath=//*[contains(text(),'添加成员')]");
		webtest.click("name=account");
		webtest.type("name=account", name);
		webtest.type("name=realname", realname);
		webtest.click("xpath=//input[@id='genderf']");
		webtest.click("xpath=//option[@value='21']");
		webtest.click("xpath=//option[@value='pm']");
		webtest.type("name=password1", password1);
		webtest.type("name=password2", password2);
		webtest.type("name=email", email);
	}

	@DataProvider(name="planData")
	public  static Object[][] getTxtData4() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/plandata.txt");
	}
	
	@Test(dataProvider = "planData")
	public void atestplan(String minute, String hour, String dom, String mon, String dow, String command) {
		// 操作
		webtest.click("xpath=//a[contains(text(),'计划任务')]");
		webtest.click("xpath=//a[contains(text(),'添加')]");
		webtest.type("name=m", minute);
		webtest.type("name=h", hour);
		webtest.type("name=dom", dom);
		webtest.type("name=mon", mon);
		webtest.type("name=dow", dow);
		webtest.type("name=command", command);
		webtest.selectByIndex("id=type", 0);
		webtest.click("xpath=//button[@id='submit']");
//		assertTrue(webtest.isTextPresent("正常"));
	}

	@DataProvider(name="backupData")
	public  static Object[][] getTxtData5() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/backupata.txt");
	}
	
	@Test(dataProvider = "backupData")
	public void testBackUp(String day) {
		// 操作
		webtest.click("xpath=//a[contains(text(),'备份')]");
		webtest.click("xpath=//a[contains(text(),'设置保存天数')]");
		webtest.typeAndClear("id=saveDays", day);
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//*[@class='btn btn-primary backup']");
		webtest.click("xpath=//button[@class='btn btn-primary']");
	}

	@Test
	public void testMD() {
		// 操作
		webtest.click("xpath=//a[contains(text(),'组织')]");
		webtest.click("xpath=//a[contains(text(),'维护部门')]");
		webtest.typeAndClear("name=children[20]", "交流部");
		webtest.typeAndClear("name=children[21]", "外交部");
		webtest.click("xpath=//button[@id='submit']");
		assertTrue(webtest.isTextPresent("外交部"));
	}

	@DataProvider(name="companyData")
	public  static Object[][] getTxtData6() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/companydata.txt");
	}
	
	@Test(dataProvider = "companyData")
	public void testCompany(String name, String body) throws InterruptedException {
		webtest.click("xpath=//*[contains(text(),'公司信息')]");
		webtest.typeAndClear("name=name", name);
		webtest.tapClick();
		webtest.type("tag=body", body);
		webtest.tapClick();
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class='close-win']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
	}

	@Test
	public void testXuanxuan() throws Exception {
		// 操作
		webtest.click("xpath=//*[contains(text(),'喧喧')]");
		webtest.click("xpath=//*[contains(text(),'重新生成密钥')]");
		webtest.click("xpath=//button[@id='submit']");
	}

	@DataProvider(name="sendingData")
	public  static Object[][] getTxtData7() throws Exception{
		return new TxtDataProvider().getTestData("dataProvider/sendingdata.txt");
	}
	
	@Test(dataProvider = "sendingData")
	public void testSending(String fromAddress, String password) throws Exception {
		// 操作
		webtest.click("xpath=//a[contains(text(),'发信')]");
		webtest.click("xpath=//input[@id='turnon0']");
		webtest.type("id=fromAddress", fromAddress);
		webtest.click("xpath=//button[@id='submit']");
		webtest.type("password", password);
		webtest.click("xpath=//button[@id='submit']");
	}
}
