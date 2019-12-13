package com.webtest.project;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Demo_gongyingshang extends BaseTest{
	@Test
	public void demo11(){
		webtest.click("link=供应商");
//		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php"
//				+ "?m=action&f=createRecord&objectType=provider&objectID=5&customer=5]");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=action&f=createRecord&objectType=provider&objectID=5&customer=5");
		webtest.runJs("document.getElementById('contact').style='display:block'");
		webtest.selectByIndex("id=contact",1);
	    webtest.type("xpath=//textarea[@id='comment']", "圣诞节沟通");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo12(){
		webtest.click("link=供应商");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=provider&f=edit&providerID=5");
//		webtest.type("xpath=/html/body", "55555");
		webtest.type("xpath=//body[@class='article-content']","这里是供应商");
		webtest.click("xpath=//button[@id='submit']");
	}
	@Test
	public void demo13(){
		webtest.click("link=供应商");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=provider&f=contact&providerID=5");
	}

}
