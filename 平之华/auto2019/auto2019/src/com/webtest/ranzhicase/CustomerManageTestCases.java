/*
 * author  ������
 * session �ͻ�����
 * caseSuccess  50
 * caseFail     0
 */

package com.webtest.ranzhicase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

@Listeners
public class CustomerManageTestCases extends BaseTest{
	@Test
	public void LoginSuccess() {
		//��ҳ��
		webtest.open("http://localhost/ranzhi/www/oa/index.php?m=attend&f=personal");
		//�ı�������
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("�˳�"));
		
	}
	
	@Test
	public void LoginFail(){
		//��ҳ��
		webtest.open("http://localhost/ranzhi/www/oa/index.php?m=attend&f=personal");
		//�ı�������
		webtest.type("name=account", "admin");
		webtest.type("name=password", "111111");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("��½ʧ�ܣ��������ĳ�Ա���������Ƿ���д��ȷ��"));
	}
	
	@Test(description="չʾ�ͻ�������ҳ")
	public void test01() throws Exception{
		LoginSuccess();//��½�ɹ�
		webtest.click("xpath=//button[@title='�ͻ�����']");//����ͻ�����
		Assert.assertTrue(webtest.isTextPresent("�ҵĶ���"));
	}
	
	@Test(description="�鿴���Ϊ9�Ķ�����ϸ��Ϣ")
	public void test02() throws Exception{
		Thread.sleep(1000);
		test01();
		webtest.click("xpath=//a[@href=/ranzhi/www/crm/index.php?m=order&f=browse]");	//�������
		webtest.click("xpath=//tr[@data-url='/ranzhi/www/crm/index.php?m=order&f=view&orderID=9']");//ָ������
		Assert.assertTrue(webtest.isTextPresent("�ر�"));
	}

	@Test(description="�����Ϊ9�Ķ���״̬��Ϊ�ѹر�")
	public void test03() throws Exception{
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=edit&orderID=9']");//�༭ָ������
		webtest.click("xpath=//select[@id='status']");//���״̬��
		webtest.click("xpath=//option[@value='closed']");//����ر�
		Thread.sleep(2000);
		webtest.click("xpath=//button[@id='submit']");//�������
	}
	
	@Test(description="�����Ϊ9�Ķ���ɾ��")
	public void test04() throws Exception{
		test02();
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=delete&orderID=9']");//���ɾ��
		webtest.goBack();//����ҳ��
	}
	
	@Test(description="�ͻ������µ�������¶���")
	public void test05() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse']");//�������
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=create']");//�����������
		Assert.assertTrue(webtest.isTextPresent("����"));
		
	}
	
	@Test(description="�������пͻ����в�Ʒ���¶���")
	public void test06() throws Exception{
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[@title='����']");
		webtest.click("xpath=//div[@id='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//div[@class='col-sm-3']");
		webtest.click("xpath=//option[@value='rmb']");
		webtest.click("xpath=//div[@class='col-sm-9']");
		webtest.type("name=plan", "11111");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test(description="�½���Ʒ��Ϣ��������")
	public void test07() throws Exception{
		test05();
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[@title='����']");
		webtest.click("xpath=//span[@class='input-group-addon']");
		webtest.type("name=productName", "���±�");
		webtest.type("name=code", "1128A");
		webtest.click("xpath=//select[@id='type']");
		webtest.click("xpath=//option[@value='service']");
		webtest.click("xpath=//div[@class='col-sm-3']");
		webtest.click("xpath=//option[@value='usd']");
		webtest.click("xpath=//div[@class='col-sm-9']");
		webtest.type("name=plan", "5555");
		webtest.click("xpath=//button[@id='submit']");
		Assert.assertTrue(webtest.isTextPresent("����ɹ�"));		
	}
	
	@Test(description="�鿴ָ�ɸ��ҵĶ���")
	public void test08() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse']");//���붩��ҳ��
		//����ָ�ɸ��ҵĶ���ҳ��
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse&mode=assignedTo']");
	}
	
	@Test(description="����ָ�ɸ��ҵĶ���")
	public void test09() throws Exception{
		webtest.click("xpath=//button[@type='button']");//�������
		//ѡ�񵼳���Χ
		webtest.click("link=������ҳ��¼");
		webtest.type("name=fileName", "ָ�ɸ��ҵĶ���");
		webtest.click("xpath=//select[@id='encode']");
		webtest.click("xpath=//option[@value='utf-8']");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		webtest.goBack();	
	}
	
	@Test(description="���ɲ��ֱ���")
	public void test10() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=report&f=browse&module=order']");
		webtest.click("xpath=//input[@value='productLine']");//����Ʒͳ��
		webtest.click("xpath=//input[@value='year']");//����ͳ��
		webtest.click("xpath=//button[type='submit']");
	}
	
	@Test(description="����ͻ������µĺ�ͬ")
	public void test11() throws Exception{
		test01();
		//�����ͬ��չʾ����δ��ɺ�ͬ
		webtest.enterFrame("iframe-1");
		webtest.click("link=��ͬ");
	}
	
	@Test(description="��ͬ��ɽ���")
	public void test12() throws Exception{
		test11();
		//�������
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=delivery&contractID=1']");
		webtest.click("xpath=//input[@name='finish']");
		//ѡ�񽻸�ʱ��
		webtest.type("name=deliveredDate", "2019-12-10");
//		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="�༭��ͬ����")
	public void test13() throws Exception{
		test11();
		//����༭�ĺ�ͬ���
		webtest.click("xpath=//td[@title='112603']");
		//����༭
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=edit&contractID=3']");
		webtest.type("name=name", "������ܶ�����ֽ");
		webtest.click("xpath=//button[@type='submit']");	
	}
	
	@Test(description="�鿴���пͻ���Ϣ")
	public void test14() throws Exception{
		test01();
		//����ͻ�
		webtest.enterFrame("iframe-1");
		webtest.click("link=�ͻ�");
		Assert.assertTrue(webtest.isTextPresent("��ӿͻ�"));		
	}
	
	@Test(description="��ӿͻ���Ϣ")
	public void test15() throws Exception{
		webtest.click("link=��ӿͻ�");
		webtest.type("name=name", "����");
		webtest.click("xpath=//select[@name='source']");
		webtest.click("xpath=//option[@value='activity']");
		webtest.type("name=sourceNote", "����");
		webtest.type("name=contact", "����ʮ");
		webtest.type("name=phone", "10086110");
		webtest.click("xpath=//select[@name='type']");
		webtest.click("xpath=//option[@value='national']");
		webtest.type("name=address[title]", "�ӱ�ʦ����ѧ");
	}
	
	@Test(description="ȫѡ�ͻ���Ϣָ���ض���")
	public void test16() throws Exception{
		test14();
		//ȫѡ
		webtest.click("xpath=//a[@id='allchecker']");
		//ָ����
		webtest.click("xpath=//div[@id='assignedTO_chosen']");
		webtest.click("xpath=//span[@title='��']");
		webtest.click("xpath=//a[contains(.,'ָ��')]");	
	}
	
	@Test(description="�鿴��Ӧ���б�")
	public void test17() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("link=��Ӧ��");
		Assert.assertTrue(webtest.isTextPresent("ά����Ŀ"));
	}
	
	@Test(description="��ӹ�Ӧ����Ϣ")
	public void test18() throws Exception{
		webtest.click("link=��ӹ�Ӧ��");
		webtest.type("name=name", "����");
		webtest.type("name=contact", "����ʮ��");
		webtest.type("name=phone", "10086112");
		webtest.type("name=qq", "20191129");
		webtest.type("weixin", "292028");
		webtest.click("xpath=//select[@name='type']");
		webtest.click("xpath=//option[@value='limited']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="�鿴��Ʒ��Ϣ")
	public void test19() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("link=��Ʒ");
		Assert.assertTrue(webtest.isTextPresent("ά������"));
	}
	
	@Test(description="��Ʒ��������")
	public void test20() throws Exception{
		
		webtest.click("ά������");
		webtest.type("name=children[11]", "��ʳ����");
		webtest.type("name=children[12]", "���ظ�ʹ����");
		webtest.click("xpath=//button[@type=submit]");
	}

	@Test(description="�����ճ��칫��ҳ")
	public void test21() throws Exception{
		LoginSuccess();//��½�ɹ�
		webtest.enterFrame("iframe-2");
		webtest.click("link=��ҳ");
		Assert.assertTrue(webtest.isTextPresent("����"));
	}
	
	@Test(description="�鿴��������")
	public void test22() throws Exception{
		test21();
		//�������
		webtest.click("link=����");
	}
	
	@Test(description="�ԼӰ���Ϊ1����������ͨ��")
	public void test23() throws Exception{
		test21();
		//����Ӱ�
		webtest.click("link=�Ӱ�");
		//������Ϊ1������ͨ��
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=overtime&f=review&id=1&status=pass']");
	}
	
	@Test(description="�޹���������¹���")
	public void test24() throws Exception {
		test21();
		//�������
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=announce&f=browse/']");
		webtest.click("xpath=//div[@id='menuActions']");
		Thread.sleep(3000);
		webtest.type("name=children[1]","�ż�ʱ��");
		webtest.type("name=children[2]","�������");
		webtest.type("name=children[3]", "��������");
		webtest.type("name=children[4]","�Ӱ����");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="���й������ӷżٹ���")
	public void test25() throws Exception{
		test21();
		webtest.click("link=����");
		webtest.click("link=��ӹ���");
		Thread.sleep(3000);
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='0']");
		webtest.type("name=title", "�ż�֪ͨ");
//		webtest.enterFrame("ke-edit-iframe");
		webtest.click("tag=body");
		webtest.type("tag=body", "Ԫ���ż�����");
		webtest.leaveFrame();
	    webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="�������")
	public void test26() throws Exception{
		test21();
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=personal']");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=leave&f=create']");
		webtest.click("xpath=//input[@value='annual']");
		webtest.type("name=begin", "2020-01-01");
		webtest.type("name=start","09:00");
		webtest.type("name=end","2020-01-03");
		webtest.type("name=finish","18:00");
		webtest.type("name=hours","72");
		webtest.type("name=desc","�������");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="�鿴�ҵ�����������")
	public void test27() throws Exception{
		test21();
		webtest.click("link=���");
		webtest.click("�ҵ����");
		Assert.assertTrue(webtest.isTextPresent("�ȴ����"));	
	}
	
	@Test(description="���ҵ���˽�������ͨ��")
	public void test28() throws Exception{
		test27();
		webtest.click("xpath=//input[@value='4']");
		webtest.click("xpath=//input[@value='3']");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("link=����ͨ��");	
	}
	
	@Test(description="����������˽�������")
	public void test29() throws Exception{
		test21();
		webtest.click("link=���");
		webtest.click("link=����");
		webtest.click("xpath=//option[@value='zhang']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="������벹����Ϣ")
	public void test30() throws Exception{
		test21();
		webtest.click("link=����");
		webtest.click("link=���벹��");
		webtest.type("name=begin","2020-01-04");
		webtest.type("name=end","2020-01-05");
		webtest.type("name=hours","30");
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="����Ӱ�ҳ��")
	public void test31() throws Exception{
		LoginSuccess();//��½�ɹ�,�����ճ��칫
		webtest.enterFrame("iframe-2");
		//����Ӱ�
		webtest.click("link=�Ӱ�");
		Assert.assertTrue(webtest.isTextPresent("����Ӱ�"));
	}
	
	@Test(description="��ӼӰ���Ϣ")
	public void test32() throws Exception{
		test31();
		//�������Ӱ�
		webtest.click("link=����Ӱ�");
		//��Ϣ�ռӰ�
		webtest.click("xpath=//input[@value='rest']");
		webtest.type("name=begin","2020-01-01");
		webtest.type("name=end", "2020-01-01");
		webtest.type("name=hours", "9");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test(description="�༭δ���ͨ���ļӰ���Ϣ")
	public void test33() throws Exception{
		//������Ϊ2�ļӰ���Ϣ
		webtest.click("xpath=//tr[@id='overtime2']");
		Thread.sleep(1000);
		webtest.click("link=�༭");
		webtest.type("name=end","2020-12-16");
		webtest.type("name=hours","24");
		webtest.type("name=desc", "ʱ�䲻��");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="ͨ���Ӱ��������ҵ����")
	public void test34() throws Exception{
		test31();
		webtest.click("link=�ҵ����");
		webtest.click("link=ȫѡ");
		webtest.click("����ͨ��");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isTextPresent("��ʱû�м�¼"));
	}
	
	@Test(description="�������")
	public void test35() throws Exception{
		LoginSuccess();
		webtest.enterFrame("iframe-2");
		//�������
		webtest.click("link=����");
		Assert.assertTrue(webtest.isTextPresent("�������"));	
	}
	
	@Test(description="��ӵ�����Ϣ")
	public void test36() throws Exception{
		test35();
		webtest.click("link=�������");
		Thread.sleep(1000);
		webtest.type("name=begin","2020-01-10");			
		webtest.type("name=end", "2020-01-10");
		webtest.type("name=hours", "15");
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//div[@class='chosen-drop']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//textarea[@id='desc']");
		webtest.type("name=desc", "��������");
		webtest.click("xpath=//button[@type='submit']");	
	}
	
	@Test(description="ȫ��ͨ���ҵ����")	
	public void test37() throws Exception{
		test35();
		webtest.click("link=�ҵ����");
		webtest.click("link=ȫѡ");
		webtest.click("link=����ͨ��");
	}
	
	@Test(description="�������ҳ��")
	public void test38() throws Exception{
		LoginSuccess();
		webtest.enterFrame("iframe-2");
		webtest.click("link=����");
		Assert.assertTrue(webtest.isTextPresent("�½�����"));		
	}
	
	@Test(description="�½�������Ϣ")
	public void test39() throws Exception{
		test38();
		webtest.click("link=�½�����");
		webtest.type("name=name","�ӱ�����");
		webtest.type("name=begin","2019-12-12");
		webtest.type("name=end","2019-12-12");
		webtest.type("name=from","ʯ��ׯ");
		webtest.type("name=to","¹Ȫ��");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="ɾ�����Ϊ1�ĳ�����Ϣ")
	public void test40() throws Exception{
		test38();
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=trip&f=delete&id=1']");
		Thread.sleep(1000);

	}

	@Test(description="������Ŀ��ҳ")
	public void test41() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-3']/button");
	    webtest.click("xpath=//*[@id='s-menu-3']/button");
	    // �������
	    Thread.sleep(3000);
	    webtest.enterFrame("iframe-3");
	    Assert.assertTrue(webtest.isTextPresent("�������"));	
	}
	
	@Test(description="�����Ŀ����")
	public void test42() throws Exception{
		test41();
		webtest.click("link=�������");
		webtest.click("xpath=//select[@name='blocks']");
		//ѡ����������
		webtest.click("xpath=//option[@value='task']");
		Thread.sleep(1000);
		webtest.type("name=title", "�����б���");
		webtest.click("xpath=//button[@type='submit']");

	}
	
	@Test(description="�����ֽ������ҳ")
	public void test43() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-5']/button");
	    webtest.click("xpath=//*[@id='s-menu-5']/button");
	    // �������
	    Thread.sleep(2000);
	    webtest.enterFrame("iframe-5");
	    Assert.assertTrue(webtest.isTextPresent("�������"));			
	}
	
	@Test(description="����˺�")
	public void test44() throws Exception{
		test43();
		webtest.click("link=�˻�");
		webtest.click("link=����˺�");
		Thread.sleep(1000);
		webtest.type("name=abbr", "�й���������");
		webtest.type("name=tags", "���ղ���5��");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="�����Ŷ���ҳ")
	public void test45() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
	    webtest.click("xpath=//*[@id='s-menu-6']/button");
	    // �������
	    Thread.sleep(3000);
	    webtest.enterFrame("iframe-6");
	
	}
	
	@Test(description="����Ŷ�������Ϣ")
	public void test46() throws Exception{
		test45();
		 //�������
	    webtest.click("link=�������");
	    webtest.click("xpath=//select[@name=blocks]");
	    webtest.click("xpath=//option[@value='blog']");
	    Thread.sleep(1000);
	    webtest.type("name=title", "������֪��");
	    webtest.typeAndClear("name=params[num]", "10");
	    webtest.click("xpath=//button[@type='submit']");		
	}
	
	@Test(description="���ò�����Ŀ")
	public void test47() throws Exception{
		test45();
		webtest.click("link=����");
		webtest.click("link=������Ŀ");
		//�༭��Ŀ
		webtest.click("xpath=//a[@href='/ranzhi/www/team/index.php?m=tree&f=edit&category=28']");
		Thread.sleep(1000);
		webtest.typeAndClear("value=С˵","��ѧ��ʶ");
		webtest.click("xpath=//input[@id='rights5']");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@DataProvider(name="excel")
	public Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("dataProvider/shixun1.xlsx","Sheet1");
	}

	@Test(dataProvider="excel",description="�������Ŀ")
	public void test48(String name1,String value1) throws Exception{
		test45();
		webtest.click("link=����");
		webtest.click("link=������Ŀ");
		webtest.click("xpath=//a[@href='/ranzhi/www/team/index.php?m=tree&f=children&type=blog&category=28&root=0']");
		webtest.type("name="+name1,value1);
		webtest.click("xpath=//button[@type='submit']");
	}
	
}
