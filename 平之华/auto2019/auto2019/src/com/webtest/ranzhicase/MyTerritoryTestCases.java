/*
 * author  ƽ֮��
 * session �ҵĵ���
 * caseSuccess 51
 * caseFail    0
 */

package com.webtest.ranzhicase;

import java.io.IOException;

import javax.net.ssl.ExtendedSSLSession;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import org.apache.commons.exec.ExecuteException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.base.Throwables;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

@Listeners
public class MyTerritoryTestCases extends BaseTest{
	
	@BeforeClass
	public void testLoginSuccess() throws Exception{
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}
	
	//����
	@Test(description="��Ӵ���")
	public void test01() throws Exception{
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
	}
	
	@Test(description="�������")
	public void test02() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@data-id='13']");
		webtest.leaveFrame();
	}
	
	@Test(description="����ָ��")
	public void test03() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=ָ��");
		webtest.click("xpath=//a[@tabindex='-1']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test(description="�༭����")
	public void test05() throws Exception{
		webtest.click("link=����");
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
	}
	
	@Test(description="��ע����")
	public void test06() throws InterruptedException{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=��ע");
		webtest.tapType("��ע");
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
	}
	
	@Test(description="�������")
	public void test07() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//div[@data-id='13']");
		Thread.sleep(3000);
		webtest.click("link=����");
		webtest.leaveFrame();
	}
	
	@Test(description="�������ҽ��찴ť")
	public void test08() throws Exception{
		webtest.click("link=����");
		webtest.click("xpath=//i[@class='btn btn-prev']");
		webtest.click("xpath=//i[@class='btn btn-next']");
		webtest.click("xpath=//i[@class='btn btn-next']");
		webtest.click("xpath=//button[contains(text(),'����')]");
		webtest.leaveFrame();
	}
	
	@Test(description="��������")
	public void test09() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//i[@class='icon-expand-full']");
		webtest.leaveFrame();
	}
	
	//����
	@Test(description="����ʱ��")
	public void test10() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=recordEstimate&taskID=5']");
		webtest.typeAndClear("name=consumed", "10.0");
		webtest.typeAndClear("name=left", "9.0");
		webtest.tapClick();
		webtest.tapType("task3");
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="ָ������")
	public void test11() throws Exception{
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
		webtest.leaveFrame();
	}
	
	@Test(description="�������")
	public void test12() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=finish&taskID=5']");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[1]/div/input", "F://WeekReport.txt");
		webtest.type("xpath=/html/body/div[4]/div[2]/div/div[2]/form/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td[2]/input", "WeekReport");
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
		webtest.leaveFrame();
	}
	
	@Test(description="��ʼ����")
	public void test13() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=start&taskID=5']");
		webtest.typeAndClear("id=realStarted", "2019-12-06");
		webtest.typeAndClear("id=left", "8.0");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	//������
	@Test(description="�༭����")
	public void test14() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=edit&taskID=5']");
		webtest.click("xpath=//select[@id='status']");
		webtest.click("xpath=//option[@value='doing']");
		webtest.typeAndClear("id=left", "9.0");
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="���������")
	public void test15() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=task&f=batchCreate&projectID=3&taskID=5']");
//		webtest.click("link=������");
		Thread.sleep(3000);
		webtest.type("name=name[0]", "task31");
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/form/div/table/tbody/tr[1]/td[3]/div/a");
		webtest.click("xpath=//li[contains(text(),'admin')]");
		webtest.type("xpath=//textarea[@id='desc[0]']", "������1");
		webtest.type("xpath=//input[@id='deadline[0]']", "2019-12-18");
		webtest.click("xpath=//select[@id='pri0']");
		webtest.click("xpath=//option[@value='2']");
		webtest.type("xpath=//input[@id='estimate[0]']", "12");
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="ѡ��ť")
	public void test16() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=ȫѡ");
		webtest.click("link=��ѡ");
		webtest.click("xpath=//input[@value='7']");
		webtest.click("xpath=//button[contains(text(),'�ر�')]");
		webtest.leaveFrame();
	}
	
	//��Ŀ
	@Test(description="������Ŀ")
	public void test17() throws Exception{
		webtest.click("link=��Ŀ");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'������Ŀ')]");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='name']");
		webtest.type("xpath=//*[@id='name']", "pro4");
		webtest.type("xpath=//input[@id='begin']", "2019-12-10");
		webtest.type("xpath=//input[@id='end']", "2019-12-12");
		webtest.click("xpath=//button[contains(text(),'����')]");
		webtest.leaveFrame();
	}
	
	@Test(description="�༭��Ŀ")
	public void test18() throws Exception{
		webtest.click("link=��Ŀ");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=edit&projectID=3']");
		webtest.typeAndClear("xpath=//input[@id='name']", "pro3");
		webtest.typeAndClear("xpath=//input[@id='begin']", "2019-12-07");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test(description="��Ŀ�Ŷ�")
	public void test19(){
		webtest.click("link=��Ŀ");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=member&projectID=3']");
		webtest.click("xpath=//div[@id='role0_chosen']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test(description="�����Ŀ")
	public void test20() throws Exception{
		webtest.click("link=��Ŀ");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=finish&projectID=3']");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="������Ŀ")
	public void test21() throws Exception{
		webtest.click("link=��Ŀ");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/proj/index.php?m=project&f=suspend&projectID=3']");
		webtest.leaveFrame();
	}
	
	//����
	@Test(description="��������1")
	public void test22() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'��������')]");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[contains(text(),'aping')]");
		webtest.click("xpath=//div[@id='product_chosen']");
//		webtest.click("xpath=//li[contains(text(),iphone)]");
		webtest.type("xpath=//input[@id='plan']", "1000");
		webtest.tapClick();
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="��������2")
	public void test23() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'��������')]");
		webtest.click("xpath=//input[@id='createCustomer']");
		webtest.type("xpath=//input[@id='name']", "cus1");
		webtest.type("xpath=//input[@id='contact']", "con1");
		webtest.type("xpath=//input[@id='phone']", "123");
		webtest.type("xpath=//input[@id='email']", "456");
		webtest.type("xpath=//input[@id='qq']", "789");
		webtest.enterClick();
		webtest.leaveFrame();
	}
	
	@Test(description="��������3")
	public void test24() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[contains(text(),'��������')]");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[contains(text(),'aping')]");
		webtest.click("xpath=//input[@id='createProduct']");
		webtest.type("xpath=//input[@id='productName']", "erji");
		webtest.type("xpath=//input[@id='code']", "123abc");
		webtest.click("xpath=//input[@id='submit']");
		webtest.leaveFrame();
		
	}
	
	@Test(description="�鿴����")
	public void test25() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		
	}
	
	@Test(description="������ͨ")
	public void test26() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=��ͨ");
		webtest.click("xpath=//div[@id='contact_chosen']");
		webtest.click("xpath=//li[contains(text(),'amu')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("����");
		for(int i=0;i<13;i++){
			webtest.tapClick();
		}
		webtest.enterClick();
		webtest.leaveFrame();
		
	}
	
	@Test(description="����ǩԼ")
	public void test27() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=ǩԼ");
		webtest.type("xpath=//input[@id='code']", "101");
		webtest.click("xpath=//select[@id='contact']");
		webtest.click("xpath=//option[contains(text(),'amu')]");
		webtest.type("xpath=//input[@id='signedDate']", "2019-12-08");
		webtest.type("xpath=//input[@id='begin']", "2019-12-08");
		webtest.type("xpath=//input[@id='end']", "2022-12-08");
		for(int i=0;i<8;i++){
			webtest.tapClick();
		}
		webtest.leaveFrame();
	}
	
	@Test(description="ָ�ɶ���")
	public void test28() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=ָ��");
		webtest.click("xpath=//div[@id='assignedTo_chosen']");
//		webtest.click("xpath=//li[contains(text(),'admin')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.leaveFrame();
	}
	
	@Test(description="�༭����")
	public void test29() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=�༭");
		webtest.typeAndClear("xpath=//input[@id='plan']", "2000");
	}
	
	@Test(description="��ע����")
	public void test30() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=��ע");
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.click("link=��ע");
		webtest.leaveFrame();
	}
	
	@Test(description="�رն���")
	public void test31() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("link=�ر�");
		webtest.click("xpath=//input[@id='closedReason']");
		webtest.click("xpath=//option[contains(text(),'�Ѹ���')]");
		webtest.tapClick();
		webtest.tapClick();
	}
	
	@Test(description="���ض���")
	public void test33() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
//		webtest.click("link=����");
		
	}
	@Test(description="���Ұ�ť")
	public void test34() throws Exception{
		webtest.click("link=����");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=view&orderID=2']");
		webtest.leaveFrame();
//		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@id='pre']");
		webtest.click("xpath=//a[@id='next']");
		webtest.click("xpath=//a[@id='next']");
		webtest.leaveFrame();
	}
	@Test(description="��ͨ����")
	public void test35() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=action&f=createRecord&objectType=order&objectID=2&customer=2']");
		webtest.click("xpath=//div[@id='contact_chosen']");
		webtest.click("xpath=//li[contains(text(),'amu')]");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("����");
		for(int i=0;i<13;i++){
			webtest.tapClick();
		}
		webtest.leaveFrame();
			
	}
	
	@Test(description="������ϵ��")
	public void test36() throws Exception{
		webtest.click("link=����");
		webtest.enterFrame("iframe-dashboard");
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=customer&f=contact&customerID=2']");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contact&f=edit&contactID=4']");
		webtest.typeAndClear("xpath=//input[@id='realname']", "ping1");
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//li[contains(text(),'aping')]");
		webtest.type("xpath=//input[@id='dept']", "����");
		webtest.type("xpath=//input[@id='title']", "����");
		webtest.type("xpath=//input[@id='join']", "2019-04-25");
		webtest.type("xpath=//input[@id='birthday']", "1999-04-25");
		webtest.click("xpath=//input[@id='genderf']");
		
	}
	
	//��ͬ
	@Test(description="��ͨ��ͬ")
	public void test40() throws Exception{
		webtest.click("link=��ͬ");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/sys/index.php?m=action&f=createRecord&objectType=contract&objectID=1&customer=1']");
		webtest.click("xpath=//div[@id='contact_chosen']");
		webtest.click("xpath=//li[contains(text(),'contact_chosen')]");
		for(int i=0;i<4;i++){
			webtest.tapClick();
		}
		webtest.tapType("����");
		for(int i=0;i<5;i++){
			webtest.tapClick();
		}
		webtest.tapType("2019-12-30");
		for(int i=0;i<3;i++){
			webtest.tapClick();
		}
	}
	
	@Test(description="��ɺ�ͬ")
	public void test41() throws Exception{
		webtest.click("link=��ͬ");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=finish&contractID=1']");
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapType("��ע");
		webtest.tapClick();
	}
	
	@Test(description="�ջ�")
	public void test42() throws Exception{
		webtest.click("link=��ͬ");
//		webtest.enterFrame("iframe-dashboard");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=receive&contractID=1']");
		webtest.type("xpath=//input[@id='amount']", "1000");
		webtest.click("xpath=//select[@id='depositor']");
		webtest.click("xpath=//option[contains(text(),'cash')]");
		webtest.click("xpath=//select[@id='category']");
		webtest.click("xpath=//option[contains(text(),'/����Ӫҵ������')]");
		webtest.type("xpath=//input[@id='returnedDate']", "2019-12-24");
	}
	
	//����
	@Test(description="����ͨ��")
	public void test44() throws Exception{
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=review&id=5&status=pass&mode=']");
	}
	
	@Test(description="�����ܾ�")
	public void test45() throws Exception{
		webtest.click("link=����");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=review&id=5&status=reject&mode=']");
	}
	
	//��̬
	
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("dataProvider/searchdata.xlsx","Sheet1");
	}
	//��̬����
	@Test(dataProvider="excel")
	public void test46(String field1,String value1,String groupAndOr,String field4,String value4) throws Exception{
		webtest.click("link=��̬");
		webtest.click("xpath=//a[contains(text(),'����')]");
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
		webtest.click("xpath=//button[contains(text(),'����')]");
	}
	
}

