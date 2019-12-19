/*
 * author 韩悦
 * session 日常办公
 * caseSuccess 44
 * caseFail    0
 */

package com.webtest.ranzhicase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Listeners
public class DailyOfficeTestCases extends BaseTest {

	@BeforeClass
	public void testLoginSuccess() throws Exception {
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}

	public void test() throws Exception {
		webtest.click("xpath=/html/body/div[1]/div[1]/div/ul[1]/li[3]/button/img");
		// webtest.enterFrame("iframe-2");
	}

	@Test(description = "添加待办1")
	public void test01() throws Exception {
		webtest.click("xpath=//td[@class='day today']");
		// webtest.click("id=types0");
		webtest.click("xpath=//option[@value='order']");
		webtest.click("id=pris0");
		webtest.click("xpath=//option[@value='1']");
		webtest.click("id=assignedTo0");
		webtest.click("xpath=//option[@value='admin']");
		webtest.type("id=descs[0]", "��������1");
		webtest.click("id=submit");
	}

	// 添加待办 2
	@Test(description = "添加待办  2")
	public void test02() throws Exception {
		// webtest.click("xpath=//td[@class='day today']");
		// webtest.click("id=types0");
		webtest.click("xpath=//option[@value='order']");
		webtest.click("id=pris0");
		webtest.click("xpath=//option[@value='1']");
		webtest.click("id=assignedTo0");
		webtest.click("xpath=//option[@value='admin']");
		webtest.type("id=descs[0]", "待办描述2");
		webtest.click("id=submit");
	}

	// 添加区块1
	@Test(description = "添加区块1")
	public void test03() throws Exception {
		webtest.click("xpath=//button[@value='admin']");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.click("id=blocks");
		webtest.click("xpath=//option[@value='announce']");
		webtest.type("id=title", "测试区块1");
	}

	// 添加区块2
	@Test(description = "添加区块2")
	public void test04() throws Exception {
		webtest.click("xpath=//button[@value='admin']");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.click("id=blocks");
		webtest.click("xpath=//option[@value='attend']");
		webtest.type("id=title", "测试区块2");
		webtest.click("id=submit");
	}

	// 公告--添加一个公告
	@Test(description = "添加一个公告")
	public void test05() throws Exception {
		webtest.click("link=公告");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.type("xpath=//input[@class='default']", "/销售部门");
		webtest.enterClick();
		webtest.type("id=title", "测试公告的标题1");
		// webtest.enterFrame("ke-edit-iframe");
		webtest.type("xpath=//body[@class='article-content']", "测试的内容1");
		webtest.click("id=submit");
	}

	// 查看公告
	@Test(description = "查看公告")
	public void test06() throws Exception {
		webtest.click("link=公告");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=announce&f=view&announceID=5']");
		webtest.click("xpath=//button[@class='close']");
	}

	// 考勤
	@Test(description = "考勤")
	public void test07() throws Exception {
		webtest.click("link=考勤");
		webtest.click("link=部门考勤");
		webtest.click("link=公司考勤");
		webtest.click("link=考勤明细");
		webtest.click("link=补录审核");
		webtest.click("link=统计");
		webtest.click("link=设置");
	}

	// 申请请假+审批
	@Test(description = "申请请假和审批")
	public void test08() throws Exception {
		test();
		webtest.click("link=请假");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.click("id=typesick");
		webtest.type("id=begin", "2020-04-12");
		webtest.type("id=end", "2020-04-13");
	}

	// 补班--删除我的补班
	@Test(description = "删除补班")
	public void test09() throws Exception {
		test();
		webtest.click("link=补班");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=makeup&f=delete&id=6']");
	}

	// 补班--所有补班--通过
	@Test(description = "补班通过")
	public void test10() throws Exception {
		test();
		webtest.click("link=补班");
		webtest.click("link=所有补班");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=makeup&f=review&id=6&status=pass']");
	}

	// 补班--设置
	@Test(description = "补班设置")
	public void test11() throws Exception {
		test();
		webtest.click("link=补班");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=overtime&f=setReviewer']");
		webtest.click("id=reviewedBy_chosen");
		webtest.click("xpath=//span[@title='部门经理']");
		webtest.click("id=submit");
	}

	// 加班--申请加班
	@Test(description = "申请加班")
	public void test12() throws Exception {
		test();
		webtest.click("link=加班");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.type("id=begin", "2020-05-12");
		webtest.type("id=end", "2020-05-13");
		webtest.type("id=desc", "加班事由测试");
		webtest.click("id=submit");
	}

	// 加班--审核我的加班
	@Test(description = "审核加班")
	public void test13() throws Exception {
		test();
		webtest.click("link=加班");
		webtest.click("link=我的审核");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=overtime&f=review&id=7&status=pass']");
	}

	// 加班--设置
	@Test(description = "加班设置")
	public void test14() throws Exception {
		test();
		webtest.click("link=加班");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=overtime&f=setReviewer']");
		webtest.click("id=reviewedBy_chosen");
		webtest.click("xpath=//span[@title='部门经理']");
		webtest.click("id=submit");
	}

	// 调休--申请一次调休
	@Test(description = "申请调休")
	public void test15() throws Exception {
		test();
		webtest.click("link=调休");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=lieu&f=create']");
		webtest.type("id=begin", "2020-06-12");
		webtest.type("id=end", "2020-06-13");
		webtest.click("xpath=//ul[@class='chosen-choices']");
		webtest.enterClick();
		webtest.type("id=desc", "调休事由测试");
		webtest.click("id=submit");
	}

	// 调休--我的审核
	@Test(description = "我的审核")
	public void test16() throws Exception {
		test();
		webtest.click("link=调休");
		webtest.click("link=我的审核");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=lieu&f=review&id=5&status=pass']");
	}

	// 调休--所有调休
	@Test(description = "所有调休")
	public void test17() throws Exception {
		test();
		webtest.click("link=调休");
		webtest.click("link=所有调休");
	}

	// 调休--设置
	@Test(description = "调休设置")
	public void test18() throws Exception {
		test();
		webtest.click("link=调休");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=lieu&f=setReviewer']");
		webtest.click("id=reviewedBy_chosen");
		webtest.click("xpath=//span[@title='部门经理']");
		webtest.click("id=submit");
	}

	// 出差
	@Test(description = "出差")
	public void test19() throws Exception {
		test();
		webtest.click("link=出差");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.type("id=name", "出差名称测试");
		webtest.type("id=end", "2019-12-30");
		webtest.type("id=from", "出发城市测试");
		webtest.type("id=to", "目的城市测试");
		webtest.click("id=submit");
		webtest.click("link=部门");
		webtest.click("link=公司");
	}

	// 外出
	@Test(description = "外出")
	public void test20() throws Exception {
		test();
		webtest.click("link=外出");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.type("id=name", "外出名称测试");
		webtest.type("id=to", "目的城市测试");
		webtest.click("id=submit");
		webtest.click("link=部门");
		webtest.click("link=公司");
	}

	// 报销
	@Test(description = "报销")
	public void test21() throws Exception {
		test();
		webtest.click("link=待审批");
		webtest.click("link=由我审批");
		webtest.click("link=待报销");
		webtest.click("link=所有报销");
	}

	// 节假日
	@Test(description = "节假日")
	public void test22() throws Exception {
		test();
		webtest.click("link=节假日");
		webtest.click("xpath=//a[@class='btn btn-primary']");
		webtest.type("id=name", "新建节假日名称测试");
		webtest.type("id=begin", "2019-12-28");
		webtest.type("id=end", "2019-12-30");
		webtest.click("id=submit");
	}

	// 设置--功能模块设置
	@Test(description = "功能模块设置")
	public void test23() throws Exception {

		webtest.click("link=设置");
		webtest.click("link=功能模块");
		webtest.click("id=submit");
	}

	// 公司考勤设置
	@Test(description = "公司考勤设置")
	public void test25() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=公司考勤设置");
		webtest.click("id=submit");
	}

	// 设置--个人考勤设置
	@Test(description = "个人考勤设置")
	public void test26() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=个人考勤设置");
		webtest.click("xpath=//a[@class='btn addItem']");
		webtest.type("id=date[]", "2019-12-30");
		webtest.click("id=submit");
	}

	// 设置--部门经理设置
	@Test(description = "部门经理设置")
	public void test27() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=部门经理设置");
		webtest.click("id=submit");
	}

	// 设置--请假设置
	@Test(description = "请假设置")
	public void test28() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=请假设置");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--补班设置
	@Test(description = "补班设置")
	public void test29() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=补班设置");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--调休设置
	@Test(description = "调休设置")
	public void test30() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=调休设置");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--加班设置
	@Test(description = "加班设置")
	public void test31() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=加班设置");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--报销审批人
	@Test(description = "报销审批人")
	public void test32() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=报销审批人");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--报销科目
	@Test(description = "报销科目")
	public void test33() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=报销科目");
		webtest.click("id=checkAll");
		webtest.click("id=submit");
	}

	// 设置--由谁报销
	@Test(description = "由谁报销")
	public void test34() throws Exception {
		webtest.click("link=设置");
		test();
		webtest.click("link=由谁报销");
		webtest.click("id=reviewedBy_chosen");
		webtest.enterClick();
		webtest.click("id=submit");
	}

	// 设置--报销账户
	@Test(description = "报销账户")
	public void test35() throws Exception {
		test();
		webtest.click("link=设置");
		webtest.click("link=报销账户");
		webtest.click("id=submit");
	}

	// 报销--设置--报销科目
	@Test(description = "报销--设置--报销科目")
	public void test36() throws Exception {
		webtest.click("link=报销");
		webtest.click("link=设置");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=refund&f=setreviewer']");
		webtest.click("id=submit");
	}

	// 报销--设置--审批人
	@Test(description = "报销--设置--审批人")
	public void test37() throws Exception {
		webtest.click("link=报销");
		webtest.click("link=设置");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=refund&f=setcategory']");
		webtest.click("id=submit");
	}

	// 报销--设置--报销账户
	@Test(description = "报销--设置--报销账户")
	public void test38() throws Exception {
		webtest.click("link=报销");
		webtest.click("link=设置");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=refund&f=setdepositor']");
		webtest.click("id=submit");
	}

	// 报销--设置--由谁报销
	@Test(description = "报销--设置--由谁报销")
	public void test39() throws Exception {
		webtest.click("link=报销");
		webtest.click("link=设置");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=refund&f=setrefundby']");
		webtest.click("id=submit");
	}

	// 外出--部门
	public void test40() throws Exception {
		webtest.click("link=外出");
		webtest.click("link=部门");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=egress&f=edit&id=2']");
		webtest.click("id=submit");
	}

	// 外出--公司
	public void test41() throws Exception {
		webtest.click("link=外出");
		webtest.click("link=公司");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=egress&f=edit&id=2']");
		webtest.click("id=submit");
	}

	// 出差--部门
	public void test42() throws Exception {
		webtest.click("link=出差");
		webtest.click("link=部门");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=trip&f=edit&id=3']");
		webtest.click("id=submit");
	}

	// 出差--公司
	public void test43() throws Exception {
		webtest.click("link=出差");
		webtest.click("link=公司");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=trip&f=edit&id=3']");
		webtest.click("id=submit");
	}

	// 节假日
	@Test(description = "节假日")
	public void test44() throws Exception {
		webtest.click("link=节假日");
		webtest.click("xpath=//a[@href='/ranzhi/www/oa/index.php?m=holiday&f=edit&id=1']");
		webtest.click("id=submit");
	}

}
