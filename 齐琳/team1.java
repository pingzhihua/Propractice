package pa;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class team1 extends login {
	@BeforeClass
	public void Login(){
		//打开页面
		webtest.open("http://localhost:8032/ranzhi/www/sys/index.php");
		//文本框输入
		webtest.type("name=account", "admin");
		webtest.type("name=password", "111111");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
		
	}



	
	
	
	@Test(description = "用户删除首页博客")
	public void testTeam01() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
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
		// 点击确定弹出框
		webtest.alertAccept();
		assertTrue(!webtest.isTextPresent("十四分"));
	}

	
	
	
	
	
	@Test(description = "用户添加博客，类目设为空值")
	public void testTeam02() throws InterruptedException {
		// 点击团队
		Thread.sleep(5000);
	    webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
		webtest.click("xpath=//*[@id='s-menu-6']/button");
		// 点击博客
		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=博客");
		// 点击添加博客
		Thread.sleep(3000);
		webtest.click("link=添加博客");
		// 选择类目，设为空值
		// 设置标题
		webtest.type("name=title","知乎者也" );
		//输入内容
//		webtest.tapClick();
//		webtest.tapClick();
//		webtest.type("tag=body", "1111");
		
		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "知之为知之不知为不知");
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("保存成功"));
		// 页面提示类目不能为空

	}

	
	
	
	@Test(description = "切换主题")
	public void testTeam03() {
		// 用户点击左下角的头像
		webtest.click("xpath=//*[@id='start']/div");
		//用户点击主题
		webtest.click("xpath=//*[@id='startMenu']/li[4]/a");
		//用户点击清晰
		webtest.click("xpath=//*[@id='startMenu']/li[4]/ul/li[2]/a");
		//页面刷新，主题切换为清晰
	}




    @Test(description="切换字体")
    public void testTeam04(){
    	// 用户点击左下角的头像
    	webtest.click("xpath=//*[@id='start']/div");
    	//用户点击简体
    	webtest.click("xpath=//*[@id='startMenu']/li[3]/a");
    	//用户点击繁体
    	webtest.click("xpath=//*[@id='startMenu']/li[3]/ul/li[1]/a");
    	//页面刷新，字体切换为繁体
    	assertTrue(!webtest.isTextPresent("保存成功"));
    }
    
    
    
    @Test(description="签到")
    public void testTeam05(){
    	webtest.click("link=签到");
    	//页面提示签到成功
    	assertTrue(!webtest.isTextPresent("签到成功"));
    	
    }
    
    
    @Test(description="签退")
    public void testTeam06(){
    	webtest.click("link=签退");
    	//页面跳转到登录页面
    	assertTrue(!webtest.isTextPresent("签退成功"));
    }
    
    
    @Test(description="点击论坛更多，页面跳转到论坛页面")
    public void testTeam07() throws InterruptedException{
       // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		// 点击首页
 		Thread.sleep(3000);
 		webtest.enterFrame("iframe-6");
 		Thread.sleep(3000);
 		webtest.click("link=首页");
 		//点击论坛后方的更多
 		webtest.click("link=更多");
 		//页面跳转多论坛页面
 		assertTrue(!webtest.isTextPresent("保存成功"));
    }
    
    
    @Test(description="点击论坛刷新，论坛版块刷新")
    public void testTeam08() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		// 点击首页
  		Thread.sleep(3000);
  		webtest.enterFrame("iframe-6");
  		Thread.sleep(3000);
  		webtest.click("link=首页");
  		//点击论坛后方的刷新按钮
  		Thread.sleep(3000);
  		webtest.click("xpath=/html/body/div/div/div[1]/div[1]/div[1]/div[1]/div/button");
  		//论坛版块刷新
  		assertTrue(!webtest.isTextPresent("保存成功"));
    }
   
    
    @Test(description="添加论坛")
    public void testTeam09() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		// 点击设置
  		Thread.sleep(3000);
  		webtest.enterFrame("iframe-6");
  		Thread.sleep(3000);
  		webtest.click("link=设置");
  		//页面跳转到设置页面
  		//在右侧版块中依次填入小说、教科书、百科全书、历史
  		webtest.click("xpath=//*[@id='children[]'']");//*[@id="children[]"]
  		webtest.type("name=children[1]", "小说");
  		webtest.click("xpath=//*[@id='children[]'']");
  		webtest.type("name=children[2]","教科书" );
  		webtest.click("xpath=//*[@id='children[]'']");
  		webtest.type("name=children[3]","百科全书" );
  		webtest.click("xpath=//*[@id='children[]'']");
  		webtest.type("name=children[4]","历史" );
  		//点击保存
  		webtest.click("xpath=//*[@id='submit']");
  		//页面提示保存成功
  		assertTrue(!webtest.isTextPresent("保存成功"));
  		
}
    
    @Test(description="为小说版块添加子版块")
    public void testTeam10() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		// 点击设置
  		Thread.sleep(3000);
  		webtest.enterFrame("iframe-6");
  		Thread.sleep(3000);
  		webtest.click("link=设置");
  		//页面跳转到设置页面
  		//点击小说版块后方的子版块
  		webtest.click("link=子版块");
  		//在右侧子版块中依次填入科幻、悬疑、历史
  		webtest.click("xpath=//*[@id='children[]']");
  		webtest.type("name=children[1]", "科幻");
  		webtest.click("xpath=//*[@id='children[]']");
  		webtest.type("name=children[2]", "悬疑");
  		webtest.click("xpath=//*[@id='children[]']");
  		webtest.type("name=children[3]", "历史");
  		//点击保存
  		webtest.click("xpath=//*[@id='submit']");
  		//页面提示保存成功
  		assertTrue(!webtest.isTextPresent("保存成功"));
  		
}
    
    
    @Test(description="删除小说版块")
    public void testTeam11() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		// 点击设置
  		Thread.sleep(3000);
  		webtest.enterFrame("iframe-6");
  		Thread.sleep(3000);
  		webtest.click("link=设置");
  		//页面跳转到设置页面
        //点击小说后方的删除
  		webtest.click("link=删除");
  		webtest.alertAccept();
		assertTrue(!webtest.isTextPresent("删除成功"));
}
    
    
    @Test(description="点击首页论坛右侧的编辑，弹出编辑区块窗口")
    public void testTeam12() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		//点击向下的按钮
  		webtest.click("xpath=///html/body/div[1]/div/div[1]/div[1]/div[1]/div[1]/div/div/button");
  		//点击编辑
  		webtest.click("link=编辑");
  		//页面弹出编辑区块窗口
  		assertTrue(webtest.isTextPresent("成功"));
}
    
    
    @Test(description="点击首页右侧的添加区块，页面弹出添加区块窗口")
    public void testTeam13() throws InterruptedException{
    	 // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		//点击页面右侧的添加区块
  		webtest.click("xpath=//*[@id='dashboard']/div[2]/a");//*[@id="dashboard"]/div[2]/a
  		//页面弹出添加区块窗口
  		assertTrue(webtest.isTextPresent("成功"));
    }
    
   
    
    
    @Test(description="点击公司，页面跳转到公司页面")
    public void testTeam14() throws InterruptedException{
   	    // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		//点击公司
 		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=公司");
 		assertTrue(webtest.isTextPresent("成功"));
 		
}
    
    
    
    
    @Test(description="用户自定义添加部门")
    public void testTeam15() throws InterruptedException{
   	    // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		//点击设置
 		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		//点击维护部门
		webtest.click("link=维护部门");
		//在部门结构中依次填入审核部门、财务部门、编辑部门
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "审核部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "财务部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[3]", "编辑部门");
		//点击保存
		webtest.click("xpath=//button[@type='submit']");
		//页面提示保存成功，并更新设置页面
		assertTrue(webtest.isTextPresent("成功"));
    }
    
    
    
    @Test(description="为审核部门添加子部门")
    public void testTeam16() throws InterruptedException{
   	    // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		//点击设置
 		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		//点击维护部门
		webtest.click("link=维护部门");
		//点击审核部门后方的子部门
		webtest.click("link=子部门");
		//在右侧子部门编辑栏中依次填入审查部门、核对部门
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[1]", "审查部门");
		webtest.click("xpath=//*[@id='children[]']");
		webtest.type("name=children[2]", "核对部门");
		//点击保存
		webtest.click("xpath=//button[@type='submit']");
		//页面提示保存成功，并更新设置页面
		assertTrue(webtest.isTextPresent("成功"));
    }	
    
    
    
    
    @Test(description="删除没有子部门的部门，如财务部门")
    public void testTeam17() throws InterruptedException{
   	    // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		//点击设置
 		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		//点击维护部门
		webtest.click("link=维护部门");
		//点击财务部门后方的删除
		webtest.click("link=删除");
		//弹出窗口，点击确定
		webtest.alertAccept();
		//页面更新，财务部门已被删除
    }
    
    
    
    @Test(description="编辑财务部门")
    public void testTeam18() throws InterruptedException{
   	    // 点击团队
 		Thread.sleep(5000);
 		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
 		webtest.click("xpath=//*[@id='s-menu-6']/button");
 		//点击设置
 		Thread.sleep(3000);
		webtest.enterFrame("iframe-6");
		Thread.sleep(3000);
		webtest.click("link=设置");
		//点击维护部门
		webtest.click("link=维护部门");
		//点击财务部门后方的编辑，页面刷新
		webtest.click("link=编辑");
		//在编辑栏中内容栏中填入“用于审查核对业务的部门”
		webtest.enterFrame(0);
		webtest.click("tag=body");
		webtest.type("tag=body", "用于审查核对业务的部门");
		webtest.leaveFrame();
		webtest.tapClick();
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("保存成功"));
    }
    
    
    
    @Test(description="点击页面左下角的所有应用，页面呈现出所有应用界面")
    public void testTeam19(){
    	// 用户点击左下角的头像
    	webtest.click("xpath=//*[@id='start']/div");
    	//用户点击所有应用
    	webtest.click("xpath=//*[@id='startMenu']/li[8]/a");
    	//页面刷新，呈现出所有应用界面
    	assertTrue(webtest.isTextPresent("成功"));
    }
    
    
    
    
    @Test(description="点击页面左下角的关于，页面刷新，并出现关于窗口")
    public void testTeam20(){
    	// 用户点击左下角的头像
    	webtest.click("xpath=//*[@id='start']/div");
    	//用户点击关于
    	webtest.click("xpath=//*[@id='startMenu']/li[5]/a");
    	assertTrue(webtest.isTextPresent("保存成功"));
    }
    
    
    
    
    @Test(description="点击页面左下角的admin，弹出个人信息窗口")
    public void testTeam21(){
    	// 用户点击左下角的头像
    	webtest.click("xpath=//*[@id='start']/div");
    	//用户点击admin头像
    	webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");
    	assertTrue(webtest.isTextPresent("保存成功"));
    	
    }
    
    
    
    @Test(description="用户编辑个人信息")
    public void testTeam22(){
    	// 用户点击左下角的头像
    	webtest.click("xpath=//*[@id='start']/div");
    	//用户点击admin头像
    	webtest.click("xpath=//*[@id='tartMenu']/li[1]/a");
    	//点击下方的编辑信息按钮
    	webtest.click("link=编辑信息");
    	//用户编辑完信息后点击下方的保存
    	webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("保存成功"));
    	
    	
    }
    
    
    
    @Test(description="在团队页面返回到桌面")
    public void testTeam23() throws InterruptedException{
        // 点击团队
  		Thread.sleep(5000);
  		webtest.mouseoverElement("xpath=//*[@id='s-menu-6']/button");
  		webtest.click("xpath=//*[@id='s-menu-6']/button");
  		//点击页面右下方的电脑按钮
  		webtest.click("xpath=//*[@id='showDesk']");
  		assertTrue(webtest.isTextPresent("保存成功"));
    }
    
