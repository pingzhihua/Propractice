package ranzhi;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

public class Login_ranzhi extends BaseTest{
	private WebDriverEngine webtest;
	  public Login_ranzhi(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  public void login() 
	  {
		  
	
		  if(is_login()) {
			webtest.click("link=Ç©ÍË");
		  }
//		  	webtest.open("http://localhost/ranzhi/www/sys");
			webtest.type("id=account","admin");
			webtest.type("id=password","admin");
			webtest.click("id=submit");		
	  }
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("link=Ç©ÍË");
	  }

}
