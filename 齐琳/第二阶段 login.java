package pa;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class login extends BaseTest {
	@Test
	public void testLogin(){
		//打开页面
		webtest.open("http://localhost:8032/ranzhi/www/sys/index.php");
		//文本框输入
		webtest.type("name=account", "admin");
		webtest.type("name=password", "admin");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
		
	}

}
