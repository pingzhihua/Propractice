package com.edu.ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddApplicationTest extends BaseTest {
	@Test
	public void testManage() throws InterruptedException {
		webtest.open("http://localhost/ranzhi/www");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@data-id='superadmin']");
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=//*[contains(text(),'添加应用')]");
		webtest.click("xpath=//a[@href]");

		webtest.type("name=name", "社区");
		webtest.type("name=abbr", "SQ");
		webtest.type("name=code", "shequ");
		webtest.type("name=login", "http://www.baidu.com");

		// 转成js来修改不可见属性，首先找到元素，把元素变为可见，然后可以利用id或者value来找元素，不推荐用class重名会很多，style中的内容要跟网页格式一样，就比如style后面的"=",display后面的“：”，
		// index从0开始算，不能单纯的看搜索出来的select的个数，得是select的标签，标签多的话用getElemetsBy...,且为类似的[0]，过程中还要数个数，看第几个。
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 2);

		webtest.click("xpath=//input[@id='groups1']");
		webtest.click("xpath=//input[@id='groups7']");
		webtest.click("xpath=//input[@id='platformranzhi']");
		webtest.click("xpath=//button[@id='submit']");

		webtest.click("xpath=//a[contains(text(),'签退')]");
	}
}
