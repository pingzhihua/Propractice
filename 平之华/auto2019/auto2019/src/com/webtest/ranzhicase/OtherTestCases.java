/*
 * author ����
 * session �Ŷ�ģ���Լ���¼���˳���ǩ����ǩ�ˡ��������⡢�������塢�༭������Ϣ����
 * caseSuccess  20
 * caseFail     27
 */

package com.webtest.ranzhicase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Listeners
public class OtherTestCases extends BaseTest{
	@BeforeClass
	public void Login() throws Exception{
		// ��ҳ��
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		// �ı�������
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("�˳�"));

	}

	@Test(description = "�û�ɾ����ҳ����")
	public void testTeam01() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ��������Ҳ�ĸ��ఴť
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='block4']/div[1]/div/div/button");
		// ���ɾ��
		Thread.sleep(3000);
		webtest.click("link=ɾ��");
	}

	@Test(description = "�û���Ӳ��ͣ���Ŀ��Ϊ��ֵ")
	public void testTeam02() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// �����Ӳ���
		Thread.sleep(3000);
		webtest.click("link=��Ӳ���");
		// ѡ����Ŀ����Ϊ��ֵ
		// ���ñ���
		webtest.type("name=title", "֪����Ҳ");
		// ��������
		// webtest.tapClick();
		// webtest.tapClick();
		// webtest.type("tag=body", "1111");

		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "֪֮Ϊ֪֮��֪Ϊ��֪");
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
		// ҳ����ʾ��Ŀ����Ϊ��

	}

	@Test(description = "�л�����")
	public void testTeam03() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û��������
		webtest.click("xpath=//*[@id='startMenu']/li[4]/a");
		// �û��������
		webtest.click("xpath=//*[@id='startMenu']/li[4]/ul/li[2]/a");
		// ҳ��ˢ�£������л�Ϊ����
	}

	@Test(description = "�л�����")
	public void testTeam04() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û��������
		webtest.click("xpath=//*[@id='startMenu']/li[3]/a");
		// �û��������
		webtest.click("xpath=//*[@id='startMenu']/li[3]/ul/li[1]/a");
		// ҳ��ˢ�£������л�Ϊ����
		Assert.assertTrue(!webtest.isTextPresent("����ɹ�"));
	}

	@Test(description = "ǩ��")
	public void testTeam05() {
		webtest.click("link=ǩ��");
		// ҳ����ʾǩ���ɹ�
		Assert.assertTrue(!webtest.isTextPresent("ǩ���ɹ�"));

	}

	@Test(description = "ǩ��")
	public void testTeam06() {
		webtest.click("link=ǩ��");
		// ҳ����ת����¼ҳ��
		Assert.assertTrue(!webtest.isTextPresent("ǩ�˳ɹ�"));
	}

	@Test(description = "�����̳���࣬ҳ����ת����̳ҳ��")
	public void testTeam07() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// �����̳�󷽵ĸ���
		webtest.click("link=����");
		// ҳ����ת����̳ҳ��
		Assert.assertTrue(!webtest.isTextPresent("����ɹ�"));
	}

	@Test(description = "�����̳ˢ�£���̳���ˢ��")
	public void testTeam08() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// �����̳�󷽵�ˢ�°�ť
		Thread.sleep(3000);
		webtest.click("xpath=/html/body/div/div/div[1]/div[1]/div[1]/div[1]/div/button");
		// ��̳���ˢ��
		Assert.assertTrue(!webtest.isTextPresent("����ɹ�"));
	}

	@Test(description = "�����̳")
	public void testTeam09() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ҳ����ת������ҳ��
		// ���Ҳ�������������С˵���̿��顢�ٿ�ȫ�顢��ʷ
		webtest.click("xpath=//*[@id='children[]'']");// *[@id="children[]"]
		webtest.type("name=children[1]", "С˵");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[2]", "�̿���");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[3]", "�ٿ�ȫ��");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[4]", "��ʷ");
		// �������
		webtest.click("xpath=//*[@id='submit']");
		// ҳ����ʾ����ɹ�
		Assert.assertTrue(!webtest.isTextPresent("����ɹ�"));

	}

	@Test(description = "ΪС˵�������Ӱ��")
	public void testTeam10() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ҳ����ת������ҳ��
		// ���С˵���󷽵��Ӱ��
		webtest.click("link=�Ӱ��");
		// ���Ҳ��Ӱ������������ƻá����ɡ���ʷ
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "�ƻ�");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "����");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[3]", "��ʷ");
		// �������
		webtest.click("xpath=//*[@id='submit']");
		// ҳ����ʾ����ɹ�
		Assert.assertTrue(!webtest.isTextPresent("����ɹ�"));

	}

	@Test(description = "ɾ��С˵���")
	public void testTeam11() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ҳ����ת������ҳ��
		// ���С˵�󷽵�ɾ��
		webtest.click("link=ɾ��");
	}

	@Test(description = "�����ҳ��̳�Ҳ�ı༭�������༭���鴰��")
	public void testTeam12() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// ������µİ�ť
		webtest.click("xpath=///html/body/div[1]/div/div[1]/div[1]/div[1]/div[1]/div/div/button");
		// ����༭
		webtest.click("link=�༭");
	}

	@Test(description = "�����ҳ�Ҳ��������飬ҳ�浯��������鴰��")
	public void testTeam13() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// ���ҳ���Ҳ���������
		webtest.click("xpath=//*[@id='dashboard']/div[2]/a");// *[@id="dashboard"]/div[2]/a
		// ҳ�浯��������鴰��
	}

	@Test(description = "�����˾��ҳ����ת����˾ҳ��")
	public void testTeam14() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����˾
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��˾");

	}

	@Test(description = "�û��Զ�����Ӳ���")
	public void testTeam15() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ���ά������
		webtest.click("link=ά������");
		// �ڲ��Žṹ������������˲��š������š��༭����
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "��˲���");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "������");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[3]", "�༭����");
		// �������
		webtest.click("xpath=//button[@type='submit']");
		// ҳ����ʾ����ɹ�������������ҳ��
	}

	@Test(description = "Ϊ��˲�������Ӳ���")
	public void testTeam16() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ���ά������
		webtest.click("link=ά������");
		// �����˲��ź󷽵��Ӳ���
		webtest.click("link=�Ӳ���");
		// ���Ҳ��Ӳ��ű༭��������������鲿�š��˶Բ���
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "��鲿��");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "�˶Բ���");
		// �������
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test(description = "ɾ��û���Ӳ��ŵĲ��ţ��������")
	public void testTeam17() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ���ά������
		webtest.click("link=ά������");
		// ��������ź󷽵�ɾ��
		webtest.click("link=ɾ��");
		// �������ڣ����ȷ��
	}
	
	@Test(description = "�༭������")
	public void testTeam18() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ���ά������
		webtest.click("link=ά������");
		// ��������ź󷽵ı༭��ҳ��ˢ��
		webtest.click("link=�༭");
		// �ڱ༭���������������롰�������˶�ҵ��Ĳ��š�
//		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "�������˶�ҵ��Ĳ���");
		webtest.leaveFrame();
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test(description = "���ҳ�����½ǵ�����Ӧ�ã�ҳ����ֳ�����Ӧ�ý���")
	public void testTeam19() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û��������Ӧ��
		webtest.click("xpath=//*[@id='startMenu']/li[8]/a");
		// ҳ��ˢ�£����ֳ�����Ӧ�ý���
	}

	@Test(description = "���ҳ�����½ǵĹ��ڣ�ҳ��ˢ�£������ֹ��ڴ���")
	public void testTeam20() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û��������
		webtest.click("xpath=//*[@id='startMenu']/li[5]/a");
	}

	@Test(description = "���ҳ�����½ǵ�admin������������Ϣ����")
	public void testTeam21() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û����adminͷ��
		webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");

	}

	@Test(description = "�û��༭������Ϣ")
	public void testTeam22() {
		// �û�������½ǵ�ͷ��
		webtest.click("xpath=//*[@id='start']/div");
		// �û����adminͷ��
		webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");
		// ����·��ı༭��Ϣ��ť
		webtest.click("link=�༭��Ϣ");
		// �û��༭����Ϣ�����·��ı���
		webtest.click("xpath=//button[@type='submit']");

	}

	@Test(description = "���Ŷ�ҳ�淵�ص�����")
	public void testTeam23() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// ���ҳ�����·��ĵ��԰�ť
		webtest.click("xpath=//*[@id='showDesk']");
	}

	@Test(description = "���Ŷ���ҳ�������")
	public void testTeam24() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ������Ϸ����������
		webtest.click("link=�������");
		// �������
		webtest.click("xpath=//*[@id='blocks']");
		// ������²���
		webtest.click("xpath=//option[@value='blog']");
		webtest.click("xpath=//button[@type='submit']");

	}

	@Test(description = "����̳�н�������")
	public void testTeam25() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����̳
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��̳");
		// ����ƻ�
		webtest.click("link=�ƻ�");

	}

	@Test(description = "�ڿƻ���̳�·���")
	public void testTeam26() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����̳
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��̳");
		// ����ƻ�
		webtest.click("link=�ƻ�");
		// ҳ���Զ���ת�Ŀƻ���̳ҳ��
		// ������Ϸ��ķ�����ť
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");

	}

	@Test(description = "��������Ϊ��")
	public void testTeam27() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����̳
		webtest.click("link=��̳");
		// ����ƻ�
		webtest.click("link=�ƻ�");
		// ҳ���Զ���ת�Ŀƻ���̳ҳ��
		// ������Ϸ��ķ�����ť
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");
		// ҳ����ת������ҳ��
		// ������⣬������ʧ��ҹ��
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "��ʧ��ҹ��");
		// �������
		webtest.click("xpath=//*[@id='submit']");
		// ҳ����ʾ����ʧ�ܣ����ݲ���Ϊ��
	}

	@Test(description = "��������Ϊ��")
	public void testTeam28() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����̳
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��̳");

		// ����ƻ�
		webtest.click("link=�ƻ�");
		// ҳ���Զ���ת�Ŀƻ���̳ҳ��
		// ������Ϸ��ķ�����ť
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");
		// ҳ����ת������ҳ��
		// ������ݣ�����123
//		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "123");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "�ڲ����µ���ƻ���Ŀ��ҳ����ת")
	public void testTeam29() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// ����ƻ�
		webtest.click("link=�ƻ�");
	}

	@Test(description = "���ͬ�£�ҳ����ʾ����ͬ����Ϣ")
	public void testTeam30() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ���ͬ�£�ҳ����ʾ����ͬ����Ϣ
		webtest.click("link=ͬ��");
	}

	@Test(description = "���ͬ��������˲��ţ��Ҳ���ʾ����˲��ŵ�����ͬ����Ϣ")
	public void testTeam31() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// ���ͬ�£�ҳ����ʾ����ͬ����Ϣ
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=ͬ��");
		// �����˲��ţ�ҳ����ʾ��˲��ŵ�ͬ����Ϣ
		webtest.click("link=��˲���");
	}

	@Test(description = "�༭���飬������²���")
	public void testTeam32() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");

		// ����������
		webtest.click("link=�������");
		// �������
		webtest.click("xpath=//*[@id='blocks']");
		// ������²���
		webtest.click("xpath=//option[@value='blog']");
		// ����������ƣ�����blog
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "blog");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "�༭���飬�����������")
	public void testTeam33() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");

		// ����������
		webtest.click("link=�������");
		// �������
		webtest.click("xpath=//*[@id='blocks']");
		// ��������б�
		webtest.click("xpath=//option[@value='thread']");
		// ����������ƣ���������
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "thread");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "��������ڵľ��岩�ͣ�ҳ����ת")
	public void testTeam34() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// �����������Ŀ�����
		webtest.click("xpath=/html/body/div/div/div[1]/div[3]/div[1]/div[2]/table/tbody/tr[1]");
	}

	@Test(description = "�����в����·�������")
	public void testTeam35() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// �����������Ŀ�����
		webtest.click("xpath=/html/body/div/div/div[1]/div[3]/div[1]/div[2]/table/tbody/tr[1]");
		// ҳ����ת�ɹ�
		// �����������������ıʺܺã�ֵ��ѧϰ
//		webtest.enterFrame(0);
		webtest.click("body=tag");
		webtest.type("body=tag", "�ıʺܺã�ֵ��ѧϰ");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "�û���Ӳ��ͣ���������Ϊ��")
	public void testTeam36() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");
		// �����Ӳ���
		webtest.click("link=��Ӳ���");
		webtest.click("xpath=//*[@id='categories_chosen']");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/form/table/tbody/tr[1]/td[1]/div[2]/ul/li[1]");
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "�����������");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "��̨������ӳ�Ա")
	public void testTeam38() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// �����ӳ�Ա
		webtest.click("link=��ӳ�Ա");
		// ������Ϣ
		webtest.click("xpath=//*[@id='account']");
		webtest.type("name=account", "����");
		webtest.click("xpath=//*[@id='genderm']");
		webtest.click("xpath=//*[@id='dept']");
		webtest.click("xpath=//option[@value='49']");
		webtest.click("xpath=//*[@id='role']");
		webtest.click("xpath=//option[@value='pm']");
		webtest.click("xpath=//*[@id='password2']");
		webtest.click("xpath=//*[@id='email']");
		webtest.type("name=email", "1234@qq.com");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "��̨�������ɾ��Ȩ�޲���")
	public void testTeam39() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// ���Ȩ��
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=Ȩ��");
		// �������Ա�󷽵�ɾ��
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[5]");
	}

	@Test(description = "��̨��������Ȩ�޷���")
	public void testTeam40() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// ���Ȩ��
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=Ȩ��");
		// �����������
		webtest.click("link=��������");
		// ������Ϣ
		webtest.click("xpath=//*[@id='name']");
		webtest.type("name=name", "�༭��Ա");
		webtest.tapClick();
		webtest.type("name=desc", "��ͨ�ı༭��Աӵ�ж���վ���б༭��Ȩ��");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "�������רԱ��ĳ�Ա��ѡ���Ա")
	public void testTeam41() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// ���Ȩ��
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=Ȩ��");
		// �������רԱ����ĳ�Ա
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[2]");
		// ѡ���һ��admin
		webtest.click("xpath=//*[@id='membersadmin']");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "�Բ���רԱ����Ӧ��Ȩ��")
	public void testTeam42() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// ���Ȩ��
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=Ȩ��");
		// �������רԱ�󷽵�Ӧ��
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[1]");
		// ҳ����ת֮��ѡ��sso�ͺ�̨
		webtest.click("xpath=//*[@id='appssso']");
		webtest.click("xpath=//*[@id='appssuperadmin']");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "ϵͳ�з�������Ϊ��")
	public void testTeam43() throws InterruptedException {
		// �����̨����
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// ���ϵͳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=ϵͳ");
		// �����һ��
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "Ϊthread�ı�����")
	public void testTeam44() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ���thread
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/button");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/ul/li[1]/a");
		// �������
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[4]/td/div/a");
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[4]/td/div/div/ul/li[2]");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "Ϊ����ѡ����ɫ")
	public void testTeam45() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ���thread
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/button");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/ul/li[1]/a");
		// �����ɫ��ѡ��
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/button");
		webtest.click(
				"xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/div/li[4]/button");
		// �������
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "������Ӻ󷽵ĸ��࣬ҳ����ת����̳ҳ��")
	public void testTeam46() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ������Ӻ���ĸ���
		webtest.click("xpath=/html/body/div/div/div[1]/div[2]/div[1]/div[1]/div/a");
	}

	@Test(description = "���ˢ�°�ť")
	public void testTeam47() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �����ҳ
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=��ҳ");
		// ������Ӻ󷽵�ˢ�°�ť
		webtest.click("xpath=/html/body/div/div/div[1]/div[2]/div[1]/div[1]/div/button");
	}

	@Test(description = "������ã�ҳ����ת������ҳ��")
	public void testTeam48() throws InterruptedException {
		// ����Ŷ�
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// �������
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=����");

	}
}
