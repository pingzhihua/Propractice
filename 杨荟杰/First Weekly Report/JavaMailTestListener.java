package JavaEmail;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
 
	//所有的测试用例执行完成
  @Override
  public void onFinish(ITestContext testContext){
	  StringBuilder str=new StringBuilder();
	  ITestNGMethod[] methods=this.getAllTestMethods();
	//  System.out.println("一共执行了"+methods.length+"条测试用例");
	  str.append("一共执行了"+methods.length+"条测试用例\n");
	  List<ITestResult> fail=this.getFailedTests();
	  //System.out.println("一共失败了"+fail.size()+"条测试用例")
	  str.append("一共失败了"+fail.size()+"条测试用例\n");
	  
	  for(ITestResult f:fail){
		  str.append(f.getInstanceName()+"-"+f.getName());
//		  Syatem.out.println(f.getInstanceName()+"-"+f.getName());
	  }
	  
	  System.out.println("所有的测试用例执行完成");
  }
}
