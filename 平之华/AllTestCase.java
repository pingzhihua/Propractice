package com.webtest.ranzhicase;

import java.io.IOException;

import javax.net.ssl.ExtendedSSLSession;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import org.apache.commons.exec.ExecuteException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Throwables;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

public class AllTestCase extends BaseTest{
	
	@BeforeClass
	public void testLoginSuccess() throws Exception{
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}
	
	//待办
	@Test
	public void testAddTodo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div[3]/div/table/tbody/tr[2]/td[5]/div/div[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//select[@id='types0']");
		webtest.click("xpath=//option[@value='task']");
		webtest.click("xpath=//select[@id='pris0']");
		webtest.click("xpath=//option[@value='2']");
		webtest.click("xpath=//select[@id='assignedTo0']");
		webtest.click("xpath=//option[@value='admin']'");
		webtest.click("id=submit");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@data-id='15']"));
	}
	
	@Test
	public void testFinish1() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@data-id='13']");
		webtest.leaveFrame();
		webtest.alertAccept();
		webtest.click("xpath=//div[@data-id='13']");
		webtest.click("xpath=//a[@data-id='13']");
		Assert.assertFalse(webtest.isTextPresent("该Todo关联的是订单 #13，需要修改它吗？"));
	}
	
	@Test
	public void testPointTo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=指派");
		webtest.click("xpath=//a[@tabindex='-1']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test
	public void testEditToDo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=编辑");
		webtest.click("xpath=//select[@id='pri']");
		webtest.click("xpath=//option[@value='1']");
		webtest.click("xpath=//select[@id='status']");
		webtest.click("xpath=//option[@value='doing']");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//div[@data-id='13']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isTextPresent("进行中"));
	}
	
	@Test
	public void testDeleteToDo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=删除");
		webtest.alertAccept();
		webtest.leaveFrame();
	}
	
	@Test
	public void testRemarkToDo() throws InterruptedException{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=备注");
		webtest.tapType("备注");
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
	}
	
	@Test
	public void testActivateToDo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=激活");
		Assert.assertTrue(webtest.isTextPresent("保存成功"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testCloseToDo() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=关闭");
		Assert.assertTrue(webtest.isTextPresent("保存成功"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testLeftRightButton() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//i[@class='btn btn-prev']");
		Assert.assertTrue(webtest.isTextPresent("2019年11月"));
		webtest.click("xpath=//i[@class='btn btn-next']");
		Assert.assertTrue(webtest.isTextPresent("2019年12月"));
		webtest.click("xpath=//i[@class='btn btn-next']");
		webtest.click("xpath=//button[contains(text(),'今天')]");
		Assert.assertTrue(webtest.isTextPresent("2019年12月"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testEnlargeDate() throws Exception{
		webtest.click("link=待办");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//i[@class='icon-expand-full']");
		Assert.assertFalse(webtest.isTextPresent("客户"));
		webtest.leaveFrame();
	}
	
	//任务
	@Test
	public void testWorkTime() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=recordEstimate&taskID=5']");
		webtest.typeAndClear("name=consumed", "10.0");
		webtest.typeAndClear("name=left", "9.0");
		webtest.tapClick();
		webtest.tapType("task3");
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("10.0"));
		Assert.assertTrue(webtest.isTextPresent("9.0"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testPointToTask() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=assignto&taskID=5']");
		webtest.click("xpath=//span[contains(text(),'admin')]");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.typeAndClear("name=left", "8.0");
		webtest.tapClick();
		webtest.tapType("备注");
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("admin"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testFinishTask() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=finish&taskID=5']");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[1]/div/input", "F://WeekReport.txt");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[2]/input", "WeekReport");
		webtest.tapClick();
		webtest.tapType("备注");
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("已完成"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testStartTask() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=start&taskID=5']");
		webtest.typeAndClear("id=realStarted", "2019-12-06");
		webtest.typeAndClear("id=left", "8.0");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isElementPresent("xpath=//td[contains(text(),'进行中')]"));
		webtest.leaveFrame();
	}
	
	//有问题
	@Test
	public void testEditTask() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=edit&taskID=5']");
		webtest.click("xpath=//select[@id='status']");
		webtest.click("xpath=//option[@value='doing']");
		webtest.typeAndClear("id=left", "9.0");
		webtest.enterClick();
		webtest.leaveFrame();
//		Assert.assertTrue(webtest.isTextPresent("进行中"));
	}
	
	@Test
	public void testChildTask() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=batchCreate&projectID=3&taskID=5']");
//		webtest.click("link=子任务");
		Thread.sleep(3000);
		webtest.type("name=name[0]", "task31");
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/form/div/table/tbody/tr[1]/td[3]/div/a");
		webtest.click("xpath=//li[contains(text(),'admin')]");
		webtest.type("xpath=//textarea[@id='desc[0]']", "子任务1");
		webtest.type("xpath=//input[@id='deadline[0]']", "2019-12-18");
		webtest.click("xpath=//select[@id='pri0']");
		webtest.click("xpath=//option[@value='2']");
		webtest.type("xpath=//input[@id='estimate[0]']", "12");
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("task31"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testChooseButton() throws Exception{
		webtest.click("link=任务");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=全选");
		webtest.click("link=反选");
		webtest.click("xpath=//input[@value='7']");
		webtest.click("xpath=//button[contains(text(),'关闭')]");
		webtest.leaveFrame();
	}
	
	//项目
	@Test
	public void testCreatePro() throws Exception{
		webtest.click("link=项目");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'创建项目')]");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='name']");
		webtest.type("xpath=//*[@id='name']", "pro4");
		webtest.type("xpath=//input[@id='begin']", "2019-12-10");
		webtest.type("xpath=//input[@id='end']", "2019-12-12");
		webtest.click("xpath=//button[contains(text(),'保存')]");
		webtest.leaveFrame();
	}
	
	@Test
	public void testEditPro() throws Exception{
		webtest.click("link=项目");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=edit&projectID=3']");
		webtest.typeAndClear("xpath=//input[@id='name']", "pro3");
		webtest.typeAndClear("xpath=//input[@id='begin']", "2019-12-07");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test
	public void testTeamPro(){
		webtest.click("link=项目");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=member&projectID=3']");
		webtest.click("xpath=//div[@id='role0_chosen']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test
	public void testFinishPro() throws Exception{
		webtest.click("link=项目");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=finish&projectID=3']");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("备注");
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testHangPro() throws Exception{
		webtest.click("link=项目");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=suspend&projectID=3']");
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	//订单
	@Test
	public void testCreateOrder1() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'创建订单')]");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[contains(text(),'aping')]");
		webtest.click("xpath=//div[@id='product_chosen']");
		webtest.click("xpath=//li[contains(text(),iphone)]");
		webtest.type("xpath=//input[@id='plan']", "1000");
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testCreateOrder2() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'创建订单')]");
		webtest.click("xpath=//input[@id='createCustomer']");
		webtest.type("xpath=//input[@id='name']", "cus1");
		webtest.type("xpath=//input[@id='contact']", "con1");
		webtest.type("xpath=//input[@id='phone']", "123");
		webtest.type("xpath=//input[@id='email']", "456");
		webtest.type("xpath=//input[@id='qq']", "789");
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testCreateOrder3() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'创建订单')]");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[contains(text(),'aping')]");
		webtest.click("xpath=//input[@id='createProduct']");
		webtest.type("xpath=//input[@id='productName']", "erji");
		webtest.type("xpath=//input[@id='code']", "123abc");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test
	public void testLookatOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		Assert.assertTrue(webtest.isTextPresent("正常"));
		
	}
	
	@Test
	public void testContactOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=沟通");
		webtest.click("xpath=//div[@id='contact_chosen']");
		webtest.click("xpath=//li[contains(text(),'amu')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("需求");
		for(int i=0;i<13;i++){
			webtest.tapClick();
		}
		webtest.enterClick();
		webtest.leaveFrame();
		
	}
	
	@Test
	public void testSignOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=签约");
		webtest.type("xpath=//input[@id='code']", "101");
		webtest.click("xpath=//select[@id='contact']");
		webtest.click("xpath=//option[contains(text(),'amu')]");
		webtest.type("xpath=//input[@id='signedDate']", "2019-12-08");
		webtest.type("xpath=//input[@id='begin']", "2019-12-08");
		webtest.type("xpath=//input[@id='end']", "2022-12-08");
		for(int i=0;i<8;i++){
			webtest.tapClick();
		}
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testPointToOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=指派");
		webtest.click("xpath=//div[@id='assignedTo_chosen']");
		webtest.click("xpath=//li[contains(text(),'admin')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testEditOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=编辑");
		webtest.typeAndClear("xpath=//input[@id='plan']", "2000");
		webtest.enterClick();
	}
	
	@Test
	public void testRemarkOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=备注");
		webtest.tapClick();
		webtest.tapType("备注");
		webtest.click("link=备注");
		webtest.leaveFrame();
	}
	
	@Test
	public void testCloseOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=关闭");
		webtest.click("xpath=//input[@id='closedReason']");
		webtest.click("xpath=//option[contains(text(),'已付款')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
	}
	
	@Test
	public void testLiveOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=激活");
		webtest.click("xpath=//div[@id='assignedTo_chosen']");
		webtest.click("xpath=//li[contains(text(),'admin')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test
	public void testBackOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("link=返回");
		Assert.assertTrue(webtest.isTextPresent("所有"));
		
	}
	
	@Test
	public void testLeftAndRight() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@id='pre']");
		Assert.assertTrue(webtest.isTextPresent("已签约"));
		webtest.click("xpath=//a[@id='next']");
		Assert.assertTrue(webtest.isTextPresent("已关闭"));
		webtest.click("xpath=//a[@id='next']");
		Assert.assertTrue(webtest.isTextPresent("信息访问受限"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testContact() throws Exception{
			webtest.click("link=订单");
			webtest.enterFrame("iframe-dashboard");
			webtest.click("link=所有");
			webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=action&f=createRecord&objectType=order&objectID=2&customer=2']");
			webtest.click("xpath=//div[@id='contact_chosen']");
			webtest.click("xpath=//li[contains(text(),'amu')]");
			webtest.tapClick();
			webtest.tapClick();
			webtest.tapClick();
			webtest.tapClick();
			webtest.tapType("需求");
			for(int i=0;i<13;i++){
				webtest.tapClick();
			}
			webtest.enterClick();
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isTextPresent("正常"));
			
	}
	
	@Test
	public void testContactPersonEdit() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=customer&f=contact&customerID=2']");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contact&f=edit&contactID=4']");
		webtest.typeAndClear("xpath=//input[@id='realname']", "ping1");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//li[contains(text(),'aping')]");
		webtest.type("xpath=//input[@id='dept']", "财务部");
		webtest.type("xpath=//input[@id='title']", "经理");
		webtest.type("xpath=//input[@id='join']", "2019-04-25");
		webtest.type("xpath=//input[@id='birthday']", "1999-04-25");
		webtest.click("xpath=//input[@id='genderf']");
		webtest.enterClick();
		
	}
	
	@Test
	public void testCreateContactPerson() throws Exception{
			webtest.click("link=订单");
			webtest.enterFrame("iframe-dashboard");
			webtest.click("link=所有");
			webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=customer&f=contact&customerID=2']");
			webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=customer&f=linkContact&customerID=2']");
			webtest.type("xpath=//input[@id='realname']", "阿华");
			webtest.click("xpath=//input[@id='genderf']");
			webtest.type("xpath=//input[@id='email']", "1720036626@qq.com");
			webtest.type("xpath=//input[@id='mobile']", "1720036621");
			webtest.type("xpath=//input[@id='phone']", "172003662");
			webtest.type("xpath=//input[@id='qq']", "17200366583");
			webtest.enterClick();
			webtest.leaveFrame();
	}
	
	@Test
	public void testLeaveJobOrder() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=customer&f=contact&customerID=2']");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=resume&f=leave&resumeID=6']");
		webtest.leaveFrame();
	}
	
	@Test
	public void testSignOrder2() throws Exception{
		webtest.click("link=订单");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=所有");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=create&customerID=2&orderID=2']");
		webtest.leaveFrame();
		webtest.enterFrame("iframe-1");
		webtest.type("xpath=//input[@id='code']", "101");
		webtest.click("xpath=//select[@id='contact']");
		webtest.click("xpath=//option[contains(text(),'amu')]");
		webtest.type("xpath=//input[@id='signedDate']", "2019-12-08");
		webtest.type("xpath=//input[@id='begin']", "2019-12-08");
		webtest.type("xpath=//input[@id='end']", "2022-12-08");
		for(int i=0;i<8;i++){
			webtest.tapClick();
		}
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	//合同
	@Test
	public void testContactAgreement() throws Exception{
		webtest.click("link=合同");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=action&f=createRecord&objectType=contract&objectID=1&customer=1']");
		webtest.click("xpath=//div[@id='contact_chosen']");
		webtest.click("xpath=//li[contains(text(),'contact_chosen')]");
		for(int i=0;i<4;i++){
			webtest.tapClick();
		}
		webtest.tapType("需求");
		for(int i=0;i<5;i++){
			webtest.tapClick();
		}
		webtest.tapType("2019-12-30");
		for(int i=0;i<3;i++){
			webtest.tapClick();
		}
		webtest.enterClick();
	}
	
	@Test
	public void testFinishAgreement() throws Exception{
		webtest.click("link=合同");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=finish&contractID=1']");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("备注");
		webtest.tapClick();
		webtest.enterClick();
	}
	
	@Test
	public void testBackMoney() throws Exception{
		webtest.click("link=合同");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=receive&contractID=1']");
		webtest.type("xpath=//input[@id='amount']", "1000");
		webtest.click("xpath=//select[@id='depositor']");
		webtest.click("xpath=//option[contains(text(),'cash')]");
		webtest.click("xpath=//select[@id='category']");
		webtest.click("xpath=//option[contains(text(),'/非主营业务收入')]");
		webtest.type("xpath=//input[@id='returnedDate']", "2019-12-24");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test
	public void testPutMoney() throws Exception{
		webtest.click("link=合同");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=delivery&contractID=1']");
		webtest.type("xpath=//input[@id='deliveredDate']", "2019-12-29");
		webtest.click("xpath=//button[@id='submit']");
		
	}
	
	//审批
	@Test
	public void testApprovalPass() throws Exception{
		webtest.click("link=审批");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=review&id=5&status=pass&mode=']");
		webtest.enterClick();
	}
	
	@Test
	public void testApprovalFail() throws Exception{
		webtest.click("link=审批");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=review&id=5&status=reject&mode=']");
		webtest.enterClick();
	}
	
	//动态
	
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("F://searchdata.xlsx","Sheet1");
	}
	
	@Test(dataProvider="excel")
	public void testSearchActions(String field1,String value1,String groupAndOr,String field4,String value4) throws Exception{
		webtest.click("link=动态");
		webtest.click("xpath=//a[contains(text(),'搜索')]");
		webtest.click("xpath=//select[@id='field1']");
		webtest.click("xpath=//option[contains(text(),field1)]");
		webtest.click("xpath=//select[@id='value1']");
		webtest.click("xpath=//option[contains(text(),value1)]");
		webtest.click("xpath=//select[@id='groupAndOr']");
		webtest.click("xpath=//option[contains(text(),groupAndOr)]");
		webtest.click("xpath=//select[@id='field4']");
		webtest.click("xpath=//option[contains(text(),field4)]");
		webtest.click("xpath=//select[@id='value4']");
		webtest.click("xpath=//option[contains(text(),value4)]");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
	}
	
}

