package pa;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


  @Test(description="用户登录时不输入用户名")
  public class team2 extends login {
	@BeforeClass
	public void Login(){
		//打开页面
		webtest.open("http://localhost:8032/ranzhi/www/sys/index.php");
		//文本框输入
//		webtest.type("name=account", "admin");
		webtest.type("name=password", "111111");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
		//页面提示登录失败
	}
  }

	
  


 
	 
 

		
	

