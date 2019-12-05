package com.webtest.ranzhicase;

import javax.net.ssl.ExtendedSSLSession;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Throwables;
import com.webtest.core.BaseTest;

public class AllTestCase extends BaseTest{
	
	@BeforeClass
	public void testLoginSuccess() throws Exception{
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}
	
	//����
	@Test
	public void testAddTodo() throws Exception{
		webtest.click("link=����");
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
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@data-id='13']");
		webtest.leaveFrame();
		webtest.alertAccept();
		webtest.click("xpath=//div[@data-id='13']");
		webtest.click("xpath=//a[@data-id='13']");
		Assert.assertFalse(webtest.isTextPresent("��Todo�������Ƕ��� #13����Ҫ�޸�����"));
	}
	
	@Test
	public void testPointTo() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=ָ��");
		webtest.click("xpath=//a[@tabindex='-1']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test
	public void testEditToDo() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=�༭");
		webtest.click("xpath=//select[@id='pri']");
		webtest.click("xpath=//option[@value='1']");
		webtest.click("xpath=//select[@id='status']");
		webtest.click("xpath=//option[@value='doing']");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//div[@data-id='13']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isTextPresent("������"));
	}
	
	@Test
	public void testDeleteToDo() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=ɾ��");
		webtest.alertAccept();
		webtest.leaveFrame();
	}
	
	@Test
	public void testRemarkToDo() throws InterruptedException{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=��ע");
		webtest.tapType("��ע");
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
	}
	
	@Test
	public void testActivateToDo() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=����");
		Assert.assertTrue(webtest.isTextPresent("����ɹ�"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testCloseToDo() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=�ر�");
		Assert.assertTrue(webtest.isTextPresent("����ɹ�"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testLeftRightButton() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//i[@class='btn btn-prev']");
		Assert.assertTrue(webtest.isTextPresent("2019��11��"));
		webtest.click("xpath=//i[@class='btn btn-next']");
		Assert.assertTrue(webtest.isTextPresent("2019��12��"));
		webtest.click("xpath=//i[@class='btn btn-next']");
		webtest.click("xpath=//button[contains(text(),'����')]");
		Assert.assertTrue(webtest.isTextPresent("2019��12��"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testEnlargeDate() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//i[@class='icon-expand-full']");
		Assert.assertFalse(webtest.isTextPresent("�ͻ�"));
		webtest.leaveFrame();
	}
	
	//����
	@Test
	public void testWorkTime() throws Exception{
		webtest.click("link=����");
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
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=assignto&taskID=5']");
		webtest.click("xpath=//span[contains(text(),'admin')]");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.typeAndClear("name=left", "8.0");
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("admin"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testFinishTask() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=finish&taskID=5']");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[1]/div/input", "F://WeekReport.txt");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[2]/input", "WeekReport");
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isTextPresent("�����"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testStartTask() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=start&taskID=5']");
		webtest.typeAndClear("id=realStarted", "2019-12-06");
		webtest.typeAndClear("id=left", "8.0");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		Assert.assertTrue(webtest.isElementPresent("xpath=//td[contains(text(),'������')]"));
		webtest.leaveFrame();
	}
	
	@Test
	public void testCloseTask() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=close&taskID=5']");
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
		webtest.enterClick();
		webtest.click("link=���ҹر�");
		Assert.assertTrue(webtest.isTextPresent("task3"));
	}
}
