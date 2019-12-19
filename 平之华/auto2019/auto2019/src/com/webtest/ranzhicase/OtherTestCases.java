/*
 * author 齐琳
 * session 团队模块以及登录、退出、签到、签退、设置主题、设置字体、编辑个人信息功能
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
		// 打开页面
		webtest.open("http://localhost:80/ranzhi/www/sys/index.php");
		// 文本框输入
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("退出"));

	}

	@Test(description = "用户删除首页博客")
	public void testTeam01() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击博客右侧的更多按钮
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='block4']/div[1]/div/div/button");
		// 点击删除
		Thread.sleep(3000);
		webtest.click("link=删除");
	}

	@Test(description = "用户添加博客，类目设为空值")
	public void testTeam02() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击博客
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=博客");
		// 点击添加博客
		Thread.sleep(3000);
		webtest.click("link=添加博客");
		// 选择类目，设为空值
		// 设置标题
		webtest.type("name=title", "知乎者也");
		// 输入内容
		// webtest.tapClick();
		// webtest.tapClick();
		// webtest.type("tag=body", "1111");

		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "知之为知之不知为不知");
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
		// 页面提示类目不能为空

	}

	@Test(description = "切换主题")
	public void testTeam03() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击主题
		webtest.click("xpath=//*[@id='startMenu']/li[4]/a");
		// 用户点击清晰
		webtest.click("xpath=//*[@id='startMenu']/li[4]/ul/li[2]/a");
		// 页面刷新，主题切换为清晰
	}

	@Test(description = "切换字体")
	public void testTeam04() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击简体
		webtest.click("xpath=//*[@id='startMenu']/li[3]/a");
		// 用户点击繁体
		webtest.click("xpath=//*[@id='startMenu']/li[3]/ul/li[1]/a");
		// 页面刷新，字体切换为繁体
		Assert.assertTrue(!webtest.isTextPresent("保存成功"));
	}

	@Test(description = "签到")
	public void testTeam05() {
		webtest.click("link=签到");
		// 页面提示签到成功
		Assert.assertTrue(!webtest.isTextPresent("签到成功"));

	}

	@Test(description = "签退")
	public void testTeam06() {
		webtest.click("link=签退");
		// 页面跳转到登录页面
		Assert.assertTrue(!webtest.isTextPresent("签退成功"));
	}

	@Test(description = "点击论坛更多，页面跳转到论坛页面")
	public void testTeam07() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击论坛后方的更多
		webtest.click("link=更多");
		// 页面跳转多论坛页面
		Assert.assertTrue(!webtest.isTextPresent("保存成功"));
	}

	@Test(description = "点击论坛刷新，论坛版块刷新")
	public void testTeam08() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击论坛后方的刷新按钮
		Thread.sleep(3000);
		webtest.click("xpath=/html/body/div/div/div[1]/div[1]/div[1]/div[1]/div/button");
		// 论坛版块刷新
		Assert.assertTrue(!webtest.isTextPresent("保存成功"));
	}

	@Test(description = "添加论坛")
	public void testTeam09() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 页面跳转到设置页面
		// 在右侧版块中依次填入小说、教科书、百科全书、历史
		webtest.click("xpath=//*[@id='children[]'']");// *[@id="children[]"]
		webtest.type("name=children[1]", "小说");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[2]", "教科书");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[3]", "百科全书");
		webtest.click("xpath=//*[@id='children[]'']");
		webtest.type("name=children[4]", "历史");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
		// 页面提示保存成功
		Assert.assertTrue(!webtest.isTextPresent("保存成功"));

	}

	@Test(description = "为小说版块添加子版块")
	public void testTeam10() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 页面跳转到设置页面
		// 点击小说版块后方的子版块
		webtest.click("link=子版块");
		// 在右侧子版块中依次填入科幻、悬疑、历史
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "科幻");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "悬疑");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[3]", "历史");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
		// 页面提示保存成功
		Assert.assertTrue(!webtest.isTextPresent("保存成功"));

	}

	@Test(description = "删除小说版块")
	public void testTeam11() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 页面跳转到设置页面
		// 点击小说后方的删除
		webtest.click("link=删除");
	}

	@Test(description = "点击首页论坛右侧的编辑，弹出编辑区块窗口")
	public void testTeam12() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击向下的按钮
		webtest.click("xpath=///html/body/div[1]/div/div[1]/div[1]/div[1]/div[1]/div/div/button");
		// 点击编辑
		webtest.click("link=编辑");
	}

	@Test(description = "点击首页右侧的添加区块，页面弹出添加区块窗口")
	public void testTeam13() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击页面右侧的添加区块
		webtest.click("xpath=//*[@id='dashboard']/div[2]/a");// *[@id="dashboard"]/div[2]/a
		// 页面弹出添加区块窗口
	}

	@Test(description = "点击公司，页面跳转到公司页面")
	public void testTeam14() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击公司
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=公司");

	}

	@Test(description = "用户自定义添加部门")
	public void testTeam15() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 点击维护部门
		webtest.click("link=维护部门");
		// 在部门结构中依次填入审核部门、财务部门、编辑部门
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "审核部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "财务部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[3]", "编辑部门");
		// 点击保存
		webtest.click("xpath=//button[@type='submit']");
		// 页面提示保存成功，并更新设置页面
	}

	@Test(description = "为审核部门添加子部门")
	public void testTeam16() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 点击维护部门
		webtest.click("link=维护部门");
		// 点击审核部门后方的子部门
		webtest.click("link=子部门");
		// 在右侧子部门编辑栏中依次填入审查部门、核对部门
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "审查部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "核对部门");
		// 点击保存
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test(description = "删除没有子部门的部门，如财务部门")
	public void testTeam17() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 点击维护部门
		webtest.click("link=维护部门");
		// 点击财务部门后方的删除
		webtest.click("link=删除");
		// 弹出窗口，点击确定
	}
	
	@Test(description = "编辑财务部门")
	public void testTeam18() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		// 点击维护部门
		webtest.click("link=维护部门");
		// 点击财务部门后方的编辑，页面刷新
		webtest.click("link=编辑");
		// 在编辑栏中内容栏中填入“用于审查核对业务的部门”
//		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "用于审查核对业务的部门");
		webtest.leaveFrame();
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test(description = "点击页面左下角的所有应用，页面呈现出所有应用界面")
	public void testTeam19() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击所有应用
		webtest.click("xpath=//*[@id='startMenu']/li[8]/a");
		// 页面刷新，呈现出所有应用界面
	}

	@Test(description = "点击页面左下角的关于，页面刷新，并出现关于窗口")
	public void testTeam20() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击关于
		webtest.click("xpath=//*[@id='startMenu']/li[5]/a");
	}

	@Test(description = "点击页面左下角的admin，弹出个人信息窗口")
	public void testTeam21() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击admin头像
		webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");

	}

	@Test(description = "用户编辑个人信息")
	public void testTeam22() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		// 用户点击admin头像
		webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");
		// 点击下方的编辑信息按钮
		webtest.click("link=编辑信息");
		// 用户编辑完信息后点击下方的保存
		webtest.click("xpath=//button[@type='submit']");

	}

	@Test(description = "在团队页面返回到桌面")
	public void testTeam23() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击页面右下方的电脑按钮
		webtest.click("xpath=//*[@id='showDesk']");
	}

	@Test(description = "在团队首页添加区块")
	public void testTeam24() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击右上方的添加区块
		webtest.click("link=添加区块");
		// 点击区块
		webtest.click("xpath=//*[@id='blocks']");
		// 点击最新博客
		webtest.click("xpath=//option[@value='blog']");
		webtest.click("xpath=//button[@type='submit']");

	}

	@Test(description = "从论坛中进入帖子")
	public void testTeam25() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击论坛
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=论坛");
		// 点击科幻
		webtest.click("link=科幻");

	}

	@Test(description = "在科幻论坛下发帖")
	public void testTeam26() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击论坛
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=论坛");
		// 点击科幻
		webtest.click("link=科幻");
		// 页面自动跳转的科幻论坛页面
		// 点击右上方的发帖按钮
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");

	}

	@Test(description = "发帖内容为空")
	public void testTeam27() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击论坛
		webtest.click("link=论坛");
		// 点击科幻
		webtest.click("link=科幻");
		// 页面自动跳转的科幻论坛页面
		// 点击右上方的发帖按钮
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");
		// 页面跳转到发帖页面
		// 点击标题，输入消失的夜晚
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "消失的夜晚");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
		// 页面提示保存失败，内容不能为空
	}

	@Test(description = "发帖标题为空")
	public void testTeam28() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击论坛
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=论坛");

		// 点击科幻
		webtest.click("link=科幻");
		// 页面自动跳转的科幻论坛页面
		// 点击右上方的发帖按钮
		webtest.click("xpath=/html/body/div/div/div[2]/div/div/div/a");
		// 页面跳转到发帖页面
		// 点击内容，输入123
//		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "123");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "在博客下点击科幻类目，页面跳转")
	public void testTeam29() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击博客
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=博客");
		// 点击科幻
		webtest.click("link=科幻");
	}

	@Test(description = "点击同事，页面显示所有同事信息")
	public void testTeam30() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击同事，页面显示所有同事信息
		webtest.click("link=同事");
	}

	@Test(description = "点击同事左侧的审核部门，右侧显示出审核部门的所有同事信息")
	public void testTeam31() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击同事，页面显示所有同事信息
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=同事");
		// 点击审核部门，页面显示审核部门的同事信息
		webtest.click("link=审核部门");
	}

	@Test(description = "编辑区块，添加最新博客")
	public void testTeam32() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");

		// 点击添加区块
		webtest.click("link=添加区块");
		// 点击区块
		webtest.click("xpath=//*[@id='blocks']");
		// 点击最新博客
		webtest.click("xpath=//option[@value='blog']");
		// 点击区块名称，填入blog
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "blog");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "编辑区块，添加最新帖子")
	public void testTeam33() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");

		// 点击添加区块
		webtest.click("link=添加区块");
		// 点击区块
		webtest.click("xpath=//*[@id='blocks']");
		// 点击帖子列表
		webtest.click("xpath=//option[@value='thread']");
		// 点击区块名称，填入帖子
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "thread");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "点击博客内的具体博客，页面跳转")
	public void testTeam34() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击博客下面的开心心
		webtest.click("xpath=/html/body/div/div/div[1]/div[3]/div[1]/div[2]/table/tbody/tr[1]");
	}

	@Test(description = "在已有博客下发表评论")
	public void testTeam35() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击博客下面的开心心
		webtest.click("xpath=/html/body/div/div/div[1]/div[3]/div[1]/div[2]/table/tbody/tr[1]");
		// 页面跳转成功
		// 点击内容输入框，输入文笔很好，值得学习
//		webtest.enterFrame(0);
		webtest.click("body=tag");
		webtest.type("body=tag", "文笔很好，值得学习");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "用户添加博客，内容设置为空")
	public void testTeam36() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击博客
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=博客");
		// 点击添加博客
		webtest.click("link=添加博客");
		webtest.click("xpath=//*[@id='categories_chosen']");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/form/table/tbody/tr[1]/td[1]/div[2]/ul/li[1]");
		webtest.click("xpath=//*[@id='title']");
		webtest.type("name=title", "今天吃晚饭了吗");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "后台管理添加成员")
	public void testTeam38() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击添加成员
		webtest.click("link=添加成员");
		// 填入信息
		webtest.click("xpath=//*[@id='account']");
		webtest.type("name=account", "李明");
		webtest.click("xpath=//*[@id='genderm']");
		webtest.click("xpath=//*[@id='dept']");
		webtest.click("xpath=//option[@value='49']");
		webtest.click("xpath=//*[@id='role']");
		webtest.click("xpath=//option[@value='pm']");
		webtest.click("xpath=//*[@id='password2']");
		webtest.click("xpath=//*[@id='email']");
		webtest.type("name=email", "1234@qq.com");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "后台管理进行删除权限操作")
	public void testTeam39() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击权限
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=权限");
		// 点击管理员后方的删除
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[5]");
	}

	@Test(description = "后台管理新增权限分组")
	public void testTeam40() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击权限
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=权限");
		// 点击新增分组
		webtest.click("link=新增分组");
		// 填入信息
		webtest.click("xpath=//*[@id='name']");
		webtest.type("name=name", "编辑人员");
		webtest.tapClick();
		webtest.type("name=desc", "普通的编辑人员拥有对网站进行编辑的权利");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "点击财务专员后的成员，选择成员")
	public void testTeam41() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击权限
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=权限");
		// 点击财务专员后面的成员
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[2]");
		// 选择第一个admin
		webtest.click("xpath=//*[@id='membersadmin']");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "对财务专员赋予应用权限")
	public void testTeam42() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击权限
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=权限");
		// 点击财务专员后方的应用
		webtest.click("xpath=/html/body/div/div/table/tbody/tr[1]/td[5]/a[1]");
		// 页面跳转之后选择sso和后台
		webtest.click("xpath=//*[@id='appssso']");
		webtest.click("xpath=//*[@id='appssuperadmin']");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "系统中发信邮箱为空")
	public void testTeam43() throws InterruptedException {
		// 点击后台管理
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-superadmin']/button");
		// 点击系统
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-superadmin");
		Thread.sleep(3000);
		webtest.click("link=系统");
		// 点击下一步
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "为thread改变类型")
	public void testTeam44() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击thread
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/button");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/ul/li[1]/a");
		// 点击类型
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[4]/td/div/a");
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[4]/td/div/div/ul/li[2]");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "为区块选择颜色")
	public void testTeam45() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击thread
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/button");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[5]/div[1]/div[1]/div/div/ul/li[1]/a");
		// 点击颜色并选择
		webtest.click("xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/button");
		webtest.click(
				"xpath=/html/body/div[2]/div[2]/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/div/li[4]/button");
		// 点击保存
		webtest.click("xpath=//*[@id='submit']");
	}

	@Test(description = "点击帖子后方的更多，页面跳转到论坛页面")
	public void testTeam46() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击帖子后面的更多
		webtest.click("xpath=/html/body/div/div/div[1]/div[2]/div[1]/div[1]/div/a");
	}

	@Test(description = "点击刷新按钮")
	public void testTeam47() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击首页
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=首页");
		// 点击帖子后方的刷新按钮
		webtest.click("xpath=/html/body/div/div/div[1]/div[2]/div[1]/div[1]/div/button");
	}

	@Test(description = "点击设置，页面跳转到设置页面")
	public void testTeam48() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击设置
		Thread.sleep(3000);
//		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");

	}
}
