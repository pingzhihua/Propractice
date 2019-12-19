/*
 * author  李文勇
 * session 客户管理
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
		//打开页面
		webtest.open("http://localhost/ranzhi/www/oa/index.php?m=attend&f=personal");
		//文本框输入
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("退出"));
		
	}
	
	@Test
	public void LoginFail(){
		//打开页面
		webtest.open("http://localhost/ranzhi/www/oa/index.php?m=attend&f=personal");
		//文本框输入
		webtest.type("name=account", "admin");
		webtest.type("name=password", "111111");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("登陆失败，请检查您的成员名或密码是否填写正确。"));
	}
	
	@Test(description="展示客户管理首页")
	public void test01() throws Exception{
		LoginSuccess();//登陆成功
		webtest.click("xpath=//button[@title='客户管理']");//点击客户管理
		Assert.assertTrue(webtest.isTextPresent("我的订单"));
	}
	
	@Test(description="查看编号为9的订单详细信息")
	public void test02() throws Exception{
		Thread.sleep(1000);
		test01();
		webtest.click("xpath=//a[@href=/ranzhi/www/crm/index.php?m=order&f=browse]");	//点击订单
		webtest.click("xpath=//tr[@data-url='/ranzhi/www/crm/index.php?m=order&f=view&orderID=9']");//指定订单
		Assert.assertTrue(webtest.isTextPresent("关闭"));
	}

	@Test(description="将编号为9的订单状态改为已关闭")
	public void test03() throws Exception{
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=edit&orderID=9']");//编辑指定订单
		webtest.click("xpath=//select[@id='status']");//点击状态栏
		webtest.click("xpath=//option[@value='closed']");//点击关闭
		Thread.sleep(2000);
		webtest.click("xpath=//button[@id='submit']");//点击保存
	}
	
	@Test(description="将编号为9的订单删除")
	public void test04() throws Exception{
		test02();
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=delete&orderID=9']");//点击删除
		webtest.goBack();//返回页面
	}
	
	@Test(description="客户管理下点击创建新订单")
	public void test05() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse']");//点击订单
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=create']");//点击创建订单
		Assert.assertTrue(webtest.isTextPresent("保存"));
		
	}
	
	@Test(description="创建已有客户已有产品的新订单")
	public void test06() throws Exception{
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[@title='张三']");
		webtest.click("xpath=//div[@id='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//div[@class='col-sm-3']");
		webtest.click("xpath=//option[@value='rmb']");
		webtest.click("xpath=//div[@class='col-sm-9']");
		webtest.type("name=plan", "11111");
		webtest.click("xpath=//button[@id='submit']");
	}
	
	@Test(description="新建产品信息创建订单")
	public void test07() throws Exception{
		test05();
		webtest.click("xpath=//div[@id='customer_chosen']");
		webtest.click("xpath=//span[@title='张三']");
		webtest.click("xpath=//span[@class='input-group-addon']");
		webtest.type("name=productName", "保温杯");
		webtest.type("name=code", "1128A");
		webtest.click("xpath=//select[@id='type']");
		webtest.click("xpath=//option[@value='service']");
		webtest.click("xpath=//div[@class='col-sm-3']");
		webtest.click("xpath=//option[@value='usd']");
		webtest.click("xpath=//div[@class='col-sm-9']");
		webtest.type("name=plan", "5555");
		webtest.click("xpath=//button[@id='submit']");
		Assert.assertTrue(webtest.isTextPresent("保存成功"));		
	}
	
	@Test(description="查看指派给我的订单")
	public void test08() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse']");//进入订单页面
		//进入指派给我的订单页面
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=order&f=browse&mode=assignedTo']");
	}
	
	@Test(description="导出指派给我的订单")
	public void test09() throws Exception{
		webtest.click("xpath=//button[@type='button']");//点击导出
		//选择导出范围
		webtest.click("link=导出本页记录");
		webtest.type("name=fileName", "指派给我的订单");
		webtest.click("xpath=//select[@id='encode']");
		webtest.click("xpath=//option[@value='utf-8']");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		webtest.goBack();	
	}
	
	@Test(description="生成部分报表")
	public void test10() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=report&f=browse&module=order']");
		webtest.click("xpath=//input[@value='productLine']");//按产品统计
		webtest.click("xpath=//input[@value='year']");//按年统计
		webtest.click("xpath=//button[type='submit']");
	}
	
	@Test(description="点击客户管理下的合同")
	public void test11() throws Exception{
		test01();
		//点击合同，展示所有未完成合同
		webtest.enterFrame("iframe-1");
		webtest.click("link=合同");
	}
	
	@Test(description="合同完成交付")
	public void test12() throws Exception{
		test11();
		//点击交付
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=delivery&contractID=1']");
		webtest.click("xpath=//input[@name='finish']");
		//选择交付时间
		webtest.type("name=deliveredDate", "2019-12-10");
//		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="编辑合同名称")
	public void test13() throws Exception{
		test11();
		//点击编辑的合同编号
		webtest.click("xpath=//td[@title='112603']");
		//点击编辑
		webtest.click("xpath=//a[@href='/ranzhi/www/crm/index.php?m=contract&f=edit&contractID=3']");
		webtest.type("name=name", "王五买很多卫生纸");
		webtest.click("xpath=//button[@type='submit']");	
	}
	
	@Test(description="查看所有客户信息")
	public void test14() throws Exception{
		test01();
		//点击客户
		webtest.enterFrame("iframe-1");
		webtest.click("link=客户");
		Assert.assertTrue(webtest.isTextPresent("添加客户"));		
	}
	
	@Test(description="添加客户信息")
	public void test15() throws Exception{
		webtest.click("link=添加客户");
		webtest.type("name=name", "黄三");
		webtest.click("xpath=//select[@name='source']");
		webtest.click("xpath=//option[@value='activity']");
		webtest.type("name=sourceNote", "集体活动");
		webtest.type("name=contact", "测试十");
		webtest.type("name=phone", "10086110");
		webtest.click("xpath=//select[@name='type']");
		webtest.click("xpath=//option[@value='national']");
		webtest.type("name=address[title]", "河北师范大学");
	}
	
	@Test(description="全选客户信息指派特定人")
	public void test16() throws Exception{
		test14();
		//全选
		webtest.click("xpath=//a[@id='allchecker']");
		//指派人
		webtest.click("xpath=//div[@id='assignedTO_chosen']");
		webtest.click("xpath=//span[@title='王']");
		webtest.click("xpath=//a[contains(.,'指派')]");	
	}
	
	@Test(description="查看供应商列表")
	public void test17() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("link=供应商");
		Assert.assertTrue(webtest.isTextPresent("维护类目"));
	}
	
	@Test(description="添加供应商信息")
	public void test18() throws Exception{
		webtest.click("link=添加供应商");
		webtest.type("name=name", "手链");
		webtest.type("name=contact", "测试十二");
		webtest.type("name=phone", "10086112");
		webtest.type("name=qq", "20191129");
		webtest.type("weixin", "292028");
		webtest.click("xpath=//select[@name='type']");
		webtest.click("xpath=//option[@value='limited']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="查看产品信息")
	public void test19() throws Exception{
		test01();
		webtest.enterFrame("iframe-1");
		webtest.click("link=产品");
		Assert.assertTrue(webtest.isTextPresent("维护分类"));
	}
	
	@Test(description="产品创建分类")
	public void test20() throws Exception{
		
		webtest.click("维护分类");
		webtest.type("name=children[11]", "可食用类");
		webtest.type("name=children[12]", "可重复使用类");
		webtest.click("xpath=//button[@type=submit]");
	}

	@Test(description="进入日常办公首页")
	public void test21() throws Exception{
		LoginSuccess();//登陆成功
		webtest.enterFrame("iframe-2");
		webtest.click("link=首页");
		Assert.assertTrue(webtest.isTextPresent("日历"));
	}
	
	@Test(description="查看所有审批")
	public void test22() throws Exception{
		test21();
		//点击审批
		webtest.click("link=审批");
	}
	
	@Test(description="对加班编号为1的审批进行通过")
	public void test23() throws Exception{
		test21();
		//点击加班
		webtest.click("link=加班");
		//点击编号为1的审批通过
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=overtime&f=review&id=1&status=pass']");
	}
	
	@Test(description="无公告下添加新公告")
	public void test24() throws Exception {
		test21();
		//点击公告
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=announce&f=browse/']");
		webtest.click("xpath=//div[@id='menuActions']");
		Thread.sleep(3000);
		webtest.type("name=children[1]","放假时间");
		webtest.type("name=children[2]","调休情况");
		webtest.type("name=children[3]", "考勤详情");
		webtest.type("name=children[4]","加班情况");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="已有公告后添加放假公告")
	public void test25() throws Exception{
		test21();
		webtest.click("link=公告");
		webtest.click("link=添加公告");
		Thread.sleep(3000);
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='0']");
		webtest.type("name=title", "放假通知");
//		webtest.enterFrame("ke-edit-iframe");
		webtest.click("tag=body");
		webtest.type("tag=body", "元旦放假三天");
		webtest.leaveFrame();
	    webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="申请年假")
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
		webtest.type("name=desc","正常年假");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="查看我的所有请假审核")
	public void test27() throws Exception{
		test21();
		webtest.click("link=请假");
		webtest.click("我的审核");
		Assert.assertTrue(webtest.isTextPresent("等待审核"));	
	}
	
	@Test(description="对我的审核进行批量通过")
	public void test28() throws Exception{
		test27();
		webtest.click("xpath=//input[@value='4']");
		webtest.click("xpath=//input[@value='3']");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("link=批量通过");	
	}
	
	@Test(description="对请假审批人进行设置")
	public void test29() throws Exception{
		test21();
		webtest.click("link=请假");
		webtest.click("link=设置");
		webtest.click("xpath=//option[@value='zhang']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="添加申请补班信息")
	public void test30() throws Exception{
		test21();
		webtest.click("link=补班");
		webtest.click("link=申请补班");
		webtest.type("name=begin","2020-01-04");
		webtest.type("name=end","2020-01-05");
		webtest.type("name=hours","30");
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="进入加班页面")
	public void test31() throws Exception{
		LoginSuccess();//登陆成功,进入日常办公
		webtest.enterFrame("iframe-2");
		//点击加班
		webtest.click("link=加班");
		Assert.assertTrue(webtest.isTextPresent("申请加班"));
	}
	
	@Test(description="添加加班信息")
	public void test32() throws Exception{
		test31();
		//点击申请加班
		webtest.click("link=申请加班");
		//休息日加班
		webtest.click("xpath=//input[@value='rest']");
		webtest.type("name=begin","2020-01-01");
		webtest.type("name=end", "2020-01-01");
		webtest.type("name=hours", "9");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test(description="编辑未审核通过的加班信息")
	public void test33() throws Exception{
		//点击编号为2的加班信息
		webtest.click("xpath=//tr[@id='overtime2']");
		Thread.sleep(1000);
		webtest.click("link=编辑");
		webtest.type("name=end","2020-12-16");
		webtest.type("name=hours","24");
		webtest.type("name=desc", "时间不够");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="通过加班中所有我的审核")
	public void test34() throws Exception{
		test31();
		webtest.click("link=我的审核");
		webtest.click("link=全选");
		webtest.click("批量通过");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isTextPresent("暂时没有记录"));
	}
	
	@Test(description="进入调休")
	public void test35() throws Exception{
		LoginSuccess();
		webtest.enterFrame("iframe-2");
		//点击调休
		webtest.click("link=调休");
		Assert.assertTrue(webtest.isTextPresent("申请调休"));	
	}
	
	@Test(description="添加调休信息")
	public void test36() throws Exception{
		test35();
		webtest.click("link=申请调休");
		Thread.sleep(1000);
		webtest.type("name=begin","2020-01-10");			
		webtest.type("name=end", "2020-01-10");
		webtest.type("name=hours", "15");
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.click("xpath=//div[@class='chosen-drop']");
		webtest.click("xpath=//li[@data-option-array-index='1']");
		webtest.click("xpath=//textarea[@id='desc']");
		webtest.type("name=desc", "家中有事");
		webtest.click("xpath=//button[@type='submit']");	
	}
	
	@Test(description="全部通过我的审核")	
	public void test37() throws Exception{
		test35();
		webtest.click("link=我的审核");
		webtest.click("link=全选");
		webtest.click("link=批量通过");
	}
	
	@Test(description="进入出差页面")
	public void test38() throws Exception{
		LoginSuccess();
		webtest.enterFrame("iframe-2");
		webtest.click("link=出差");
		Assert.assertTrue(webtest.isTextPresent("新建出差"));		
	}
	
	@Test(description="新建出差信息")
	public void test39() throws Exception{
		test38();
		webtest.click("link=新建出差");
		webtest.type("name=name","河北考察");
		webtest.type("name=begin","2019-12-12");
		webtest.type("name=end","2019-12-12");
		webtest.type("name=from","石家庄");
		webtest.type("name=to","鹿泉区");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="删除编号为1的出差信息")
	public void test40() throws Exception{
		test38();
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=trip&f=delete&id=1']");
		Thread.sleep(1000);

	}

	@Test(description="进入项目首页")
	public void test41() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-3']/button");
	    webtest.click("xpath=//*[@id='s-menu-3']/button");
	    // 点击设置
	    Thread.sleep(3000);
	    webtest.enterFrame("iframe-3");
	    Assert.assertTrue(webtest.isTextPresent("添加区块"));	
	}
	
	@Test(description="添加项目区块")
	public void test42() throws Exception{
		test41();
		webtest.click("link=添加区块");
		webtest.click("xpath=//select[@name='blocks']");
		//选择任务区块
		webtest.click("xpath=//option[@value='task']");
		Thread.sleep(1000);
		webtest.type("name=title", "任务列表栏");
		webtest.click("xpath=//button[@type='submit']");

	}
	
	@Test(description="进入现金记账首页")
	public void test43() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-5']/button");
	    webtest.click("xpath=//*[@id='s-menu-5']/button");
	    // 点击设置
	    Thread.sleep(2000);
	    webtest.enterFrame("iframe-5");
	    Assert.assertTrue(webtest.isTextPresent("添加区块"));			
	}
	
	@Test(description="添加账号")
	public void test44() throws Exception{
		test43();
		webtest.click("link=账户");
		webtest.click("link=添加账号");
		Thread.sleep(1000);
		webtest.type("name=abbr", "中国工商银行");
		webtest.type("name=tags", "单日不超5万");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	@Test(description="进入团队首页")
	public void test45() throws Exception{
		LoginSuccess();
		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
	    webtest.click("xpath=//*[@id='s-menu-6']/button");
	    // 点击设置
	    Thread.sleep(3000);
	    webtest.enterFrame("iframe-6");
	
	}
	
	@Test(description="添加团队区块信息")
	public void test46() throws Exception{
		test45();
		 //添加区块
	    webtest.click("link=添加区块");
	    webtest.click("xpath=//select[@name=blocks]");
	    webtest.click("xpath=//option[@value='blog']");
	    Thread.sleep(1000);
	    webtest.type("name=title", "博客早知道");
	    webtest.typeAndClear("name=params[num]", "10");
	    webtest.click("xpath=//button[@type='submit']");		
	}
	
	@Test(description="设置博客类目")
	public void test47() throws Exception{
		test45();
		webtest.click("link=设置");
		webtest.click("link=博客类目");
		//编辑类目
		webtest.click("xpath=//a[@href='/ranzhi/www/team/index.php?m=tree&f=edit&category=28']");
		Thread.sleep(1000);
		webtest.typeAndClear("value=小说","文学常识");
		webtest.click("xpath=//input[@id='rights5']");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@DataProvider(name="excel")
	public Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("dataProvider/shixun1.xlsx","Sheet1");
	}

	@Test(dataProvider="excel",description="添加子类目")
	public void test48(String name1,String value1) throws Exception{
		test45();
		webtest.click("link=设置");
		webtest.click("link=博客类目");
		webtest.click("xpath=//a[@href='/ranzhi/www/team/index.php?m=tree&f=children&type=blog&category=28&root=0']");
		webtest.type("name="+name1,value1);
		webtest.click("xpath=//button[@type='submit']");
	}
	
}
