package JavaEmail;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
 
	//���еĲ�������ִ�����
  @Override
  public void onFinish(ITestContext testContext){
	  StringBuilder str=new StringBuilder();
	  ITestNGMethod[] methods=this.getAllTestMethods();
	//  System.out.println("һ��ִ����"+methods.length+"����������");
	  str.append("һ��ִ����"+methods.length+"����������\n");
	  List<ITestResult> fail=this.getFailedTests();
	  //System.out.println("һ��ʧ����"+fail.size()+"����������")
	  str.append("һ��ʧ����"+fail.size()+"����������\n");
	  
	  for(ITestResult f:fail){
		  str.append(f.getInstanceName()+"-"+f.getName());
//		  Syatem.out.println(f.getInstanceName()+"-"+f.getName());
	  }
	  
	  System.out.println("���еĲ�������ִ�����");
  }
}
