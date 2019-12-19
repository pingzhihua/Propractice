/*
 * author 杨荟杰
 * session 现金记账
 * caseSuccess 26
 * caseFail    26
 */

package com.webtest.ranzhicase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

@Listeners
public class CashAccountTestCases extends BaseTest {

	@BeforeClass
	public void testLoginSuccess() throws Exception {
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}

	@DataProvider(name = "movie1")
	public Object[][] getMovieData1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("dataProvider/data.xlsx", "Sheet3");
	}

	@Test(dataProvider = "movie1")
	public void addspend(String a, String b) throws InterruptedException {
		// 支出
		webtest.click("link=支出");
		webtest.click("link=记支出");
		// 新建支出**
		// 账号
		// webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 4);
		// 产品
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product", 1);
		// 科目
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 3);
		// 类型
		webtest.click("xpath=//input[@id='objectTypecustomer']");
		// 客户
		webtest.runJs("document.getElementById('customer').style='display:block'");
		webtest.selectByIndex("id=customer", 1);
		// 金额
		webtest.type("xpath=//input[@id='money']", a);
		webtest.type("xpath=//input[@id='exchangeRate']", b);
		// 部门
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept", 5);
		// 经手人
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers", 3);
		webtest.selectByIndex("id=handlers", 3);
		// 交易时间
		webtest.typeAndClear("xpath=//input[@id='date']", "2019-11-10");
		webtest.clickLonger("xpath=//input[@id='date']");
		// 说明
		webtest.type("xpath=//textarea[@id='desc']", "2222222");
		// 保存
		webtest.click("xpath=//button[@id='submit']");
		// Thread.sleep(4000);
		// webtest.leaveFrame();
		// webtest.click("link=签退");
		Assert.assertTrue(webtest.isTextPresent("退出"));
	}

	@DataProvider(name = "movie2")
	public Object[][] getMovieData2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("dataProvider/data.xlsx", "Sheet1");
	}

	@Test(dataProvider = "movie2")
	public void testmoney(String a, String b) throws InterruptedException {
		// 收入
		webtest.click("link=收入");
		webtest.click("link=记收入");
		// 新建收入****
		// 账号
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 2);
		// 产品
		webtest.runJs("document.getElementById('product').style='display:block'");
		webtest.selectByIndex("id=product", 2);
		// 科目
		webtest.runJs("document.getElementById('category').style='display:block'");
		webtest.selectByIndex("id=category", 2);
		// 客户
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader", 2);

		webtest.type("xpath=//input[@id='money']", a);
		// 部门
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept", 3);
		// 经手人
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers", 1);
		// 交易时间
		webtest.typeAndClear("xpath=//input[@id='date']", "2019-11-10");
		webtest.clickLonger("xpath=//input[@id='date']");
		// 说明
		webtest.type("xpath=//textarea[@id='desc']", b);
		// 保存
		webtest.click("xpath=//button[@id='submit']");
		// webtest.leaveFrame();
		// webtest.click("link=签退");
		Assert.assertTrue(webtest.isTextPresent("退出"));
	}

	@DataProvider(name = "movie3")
	public Object[][] getMovieData3() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("dataProvider/data.xlsx", "Sheet2");
	}

	@Test(dataProvider = "movie3")
	public void newaccount(String a, String b) throws InterruptedException {

		// 账户
		webtest.click("link=账户");
		// 新建账户
		webtest.click("link=添加账号");
		webtest.type("xpath=//select[@id='type']", "现金账号");
		webtest.type("xpath=//input[@id='abbr']", a);
		webtest.type("xpath=//input[@id='tags']", b);
		webtest.type("xpath=//select[@id='currency']", "美元");
		// 保存
		webtest.click("xpath=//button[@id='submit']");
		// webtest.leaveFrame();
		// webtest.click("link=签退");
	}

	@DataProvider(name = "movie4")
	public Object[][] getMovieData4() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("dataProvider/data.xlsx", "Sheet2");
	}

	@Test(dataProvider = "movie4")
	public void touzi(String a, String b) {
		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=browse&mode=invest]");
		webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php?m=trade&f=invest&type=invest]");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 2);
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader", 4);
		webtest.type("xpath=//input[@id='money']", a);
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept", 3);
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers", 1);
		webtest.typeAndClear("xpath=//input[@id='deadline']", "2019-11-10");
		webtest.clickLonger("xpath=//input[@id='deadline']");
		webtest.type("xpath=//textarea[@id='desc']", b);
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
	}

	@Test
	public void checkaccount() throws InterruptedException {
		// 对账
		webtest.click("link=对账");
		// 筛选条件
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 3);
		webtest.type("xpath=//select[@id='start']", "2019-12-01");
		webtest.type("xpath=//select[@id='end']", "2019-12-03");
		// 对账
		webtest.click("xpath=//button[@id='submit']");
		webtest.click("xpath=//button[@id='submit']");
		// webtest.leaveFrame();
		// webtest.click("link=签退");
	}

	@Test(description = "搜索")
	public void demo01() {
		webtest.click("link=所有");
		webtest.click("xpath=//a[href=/ranzhi/www/cash/index.php?m=trade&f=browse&mode=all&date=201912]");
		webtest.click("link=搜索");
	}

	@Test(description = "搜索")
	public void demo02() {
		webtest.click("link=所有");
		webtest.click("link=搜索");
		webtest.runJs("document.getElementById('value1').style='display:block'");
		webtest.selectByIndex("id=value1", 3);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test(description = "批量记账")
	public void demo03() {
		webtest.click("link=所有");
		webtest.click("link=批量记账");
		webtest.runJs("document.getElementById('depositor0').style='display:block'");
		webtest.selectByIndex("id=depositor0", 6);
		webtest.runJs("document.getElementById('category0').style='display:block'");
		webtest.selectByIndex("id=category0", 2);
		webtest.type("xpath=//input[@id='money[0]']", "999");
		webtest.runJs("document.getElementById('handlers0').style='display:block'");
		webtest.selectByIndex("id=handlers0", 1);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo04() {
		webtest.click("link=所有");
		webtest.click("xpath=//a[@id='_recPerPage']");
		webtest.click("xpath=//a[@id='javascript:submitPage('changeRecPerPage', 10)']");
	}

	@Test
	public void demo05() {
		webtest.click("link=ÊÕÈë");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@id='submit']");
		webtest.type("xpath=//input[@id='money6']", "60000");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo06() {
		webtest.click("link=ÊÕÈë");
		webtest.click("xpath=//input[@value='28']");
		webtest.click("xpath=//input[@value='30']");
		webtest.click("xpath=//a[@id='reversechecker']");
	}

	@Test
	public void demo07() {
		webtest.click("link=设置");
		webtest.type("xpath=//input[@name='children[3]']", "副业收入");
		webtest.type("xpath=//input[@name='children[4]']", "子公司收入");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo08() {
		webtest.click("link=设置");
		webtest.click("link=支出科目");
		webtest.type("xpath=//input[@name='children[3]']", "项目失败支出");
		webtest.type("xpath=//input[@name='children[4]']", "子公司支出");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo09() {
		webtest.click("link=设置");
		webtest.click("link=货币类型");
		webtest.click("xpath=//input[@value='thb']");
		webtest.click("xpath=//input[@value='sur']");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo10() {
		webtest.click("link=设置");
		webtest.click("link=记账设置");
		webtest.click("xpath=//input[@name='trader']");
		webtest.click("xpath=//input[@name='product']");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo11() {
		webtest.click("link=供应商");
		// webtest.click("xpath=//a[@href=/ranzhi/www/cash/index.php"
		// +
		// "?m=action&f=createRecord&objectType=provider&objectID=5&customer=5]");
		webtest.open(
				"http://localhost/ranzhi/www/cash/index.php?m=action&f=createRecord&objectType=provider&objectID=5&customer=5");
		webtest.runJs("document.getElementById('contact').style='display:block'");
		webtest.selectByIndex("id=contact", 1);
		webtest.type("xpath=//textarea[@id='comment']", "圣诞节沟通");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo12() {
		webtest.click("link=供应商");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=provider&f=edit&providerID=5");
		// webtest.type("xpath=/html/body", "55555");
		webtest.type("xpath=//body[@class='article-content']", "这里是供应商");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo13() {
		webtest.click("link=供应商");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=provider&f=contact&providerID=5");
	}

	@Test
	public void demo14() {
		webtest.click("link=账户");
		webtest.click("link=xx专用");
		webtest.click("link=55");
		webtest.click("link=禁用账号");
	}

	@Test
	public void demo15() {
		webtest.click("link=账户");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=balance&f=browse&depositorID=3");
	}

	@Test
	public void demo16() {
		webtest.click("link=账户");
		webtest.click("link=禁用账号");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=activate&depositorID=5");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo17() {
		webtest.click("link=账户");
		webtest.click("link=xx专用");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=forbid&depositorID=10");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo18() {
		webtest.click("link=账户");
		webtest.click("link=55");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=depositor&f=edit&depositorID=13");
		webtest.type("xpath=//input[@id='tags']", "这里是备注");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo19() {
		webtest.click("link=报表");
		webtest.click("link=人民币");
		webtest.click("link=美元");
		webtest.click("link=千元");
		webtest.click("link=万元");
	}

	@Test
	public void demo20() {
		webtest.click("link=报表");
		webtest.click("link=年度对比表");
		webtest.selectByIndex("id=currency", 2);
		webtest.selectByIndex("id=unit", 3);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo21() {
		webtest.click("link=报表");
		webtest.click("link=账号盈亏表");
		webtest.type("id=fileName", "2019账号盈亏表");
		webtest.click("xpath=//option[@value=xlsx]");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo22() {
		webtest.click("link=报表");
		webtest.click("link=报表单位");
		webtest.selectByIndex("id=unit", 3);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo23() {
		webtest.click("link=对账");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 5);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo24() {
		webtest.click("link=对账");
		webtest.runJs("document.getElementById('depositor').style='display:block'");
		webtest.selectByIndex("id=depositor", 1);
		webtest.type("xpath=//select[@id='end']", "2019-12-03");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo25() {
		webtest.click("link=借贷");
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=view&tradeID=25&mode=loan");
		webtest.click("xpath=//a[@id='backButton']");
	}

	@Test
	public void demo26() {
		webtest.click("link=借贷");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=detail&tradeID=23&mode=loan");
		webtest.type("xpath=//input[@id='money[0]']", "444");
		webtest.type("xpath=//textarea[@id='desc[0]']", "这里是说明");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo27() {
		webtest.click("link=借贷");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=24&mode=loan");
		webtest.runJs("document.getElementById('trader').style='display:block'");
		webtest.selectByIndex("id=trader", 4);
		webtest.type("xpath=//textarea[@id='desc']", "借贷");
		webtest.click("xpath=//a[@id='backButton']");
	}

	@Test
	public void demo28() {
		webtest.click("link=借贷");
		webtest.click("link=搜索");
		webtest.runJs("document.getElementById('value1').style='display:block'");
		webtest.selectByIndex("id=value1", 4);
		webtest.runJs("document.getElementById('value4').style='display:block'");
		webtest.selectByIndex("id=value4", 3);
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void demo29() {
		webtest.click("link=借贷");
		webtest.click("link=还贷");
		webtest.selectByIndex("id=depositor", 4);
		webtest.selectByIndex("id=loanID", 2);
		webtest.type("xpath=//input[@id='money']", "3000");
		webtest.type("xpath=//input[@id='interest']", "300");
		webtest.runJs("document.getElementById('dept').style='display:block'");
		webtest.selectByIndex("id=dept", 4);
		webtest.runJs("document.getElementById('handlers').style='display:block'");
		webtest.selectByIndex("id=handlers", 4);
		webtest.type("xpath=//textarea[@id='desc']", "这是还贷");
		webtest.click("xpath=//a[@id='backButton']");
	}

	@Test
	public void demo30() {
		webtest.click("link=转账");
		webtest.open("http://localhost//ranzhi/www/cash/index.php?m=trade&f=detail&tradeID=13&mode=transfer");
		webtest.type("xpath=//input[@id='money[0]']", "555");
		webtest.type("xpath=//textarea[@id='desc[0]']", "给供应商投资");
		webtest.click("xpath=//button[@id='submit']");
	}

	@Test
	public void edittranser() throws InterruptedException {
		// 转账
		webtest.click("link=转账");
		// 选择编辑
		webtest.open("http://localhost/ranzhi/www/cash/index.php?m=trade&f=edit&tradeID=16&mode=transfer");

		webtest.type("xpath=//textarea[@id='desc']", "xinde!!!!!!!!!!");
		// 保存
		webtest.click("xpath=//button[@id='submit']");
		webtest.leaveFrame();
		webtest.click("link=签退");
	}

}
