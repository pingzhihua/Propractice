package com.webtest.project;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Edit_transfer_Test extends BaseTest{
	@Test
	public void edittranser() throws InterruptedException{
		//ת��
		webtest.click("link=ת��");
		//ѡ��༭
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer");

		webtest.type("xpath=//textarea[@id='desc']","xinde!!!!!!!!!!");
		//����
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=ǩ��");
		assertTrue(webtest.isTextPresent("�˳�"));
	}
	@Test
	public void demo30(){
		webtest.click("link=ת��");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=detail&tradeID=13&mode=transfer");
		webtest.type("xpath=//input[@id='money[0]']","555");
		webtest.type("xpath=//textarea[@id='desc[0]']","����Ӧ��Ͷ��");
		webtest.click("xpath=//button[@id='submit']");
	}
	

}
