package com.webtest.core;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.Log;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 * ������������ʧ�ܣ�����
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"����ʧ�ܣ���Ҫ����");
		  BaseTest tb = (BaseTest) tr.getInstance();
		 
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		try {
			ss.screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  Log.info(tr.getInstance()+"-"+tr.getName()+"���гɹ�");
	  }
	  
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
//			  Syatem.out.println(f.getInstanceName()+"-"+f.getName());
		  }
		  
		  System.out.println("���еĲ�������ִ�����");
	  }
	  
	  
	  
	  
//	  @Override
//		public void onFinish(ITestContext testContext) {
//			//��ȡ��ǰʱ��
//			Date date = new Date();
//			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			String now = dateFormat.format(date);
//			//���в�����������
//			ITestNGMethod[] allTest = testContext.getAllTestMethods();
//			int count = allTest.length;
//			//ʧ�ܲ�����������
//			Set<ITestResult> tResultsFail = testContext.getFailedTests().getAllResults();
//			int failCount = tResultsFail.size();
//			//�ɹ���������
//			Set<ITestResult> trSuccess = testContext.getPassedTests().getAllResults();
//			
//			String out = Freemarker.getFreemarker(now, count, failCount, trSuccess);
//			
//			String tomail;
//			try {
//				tomail = ReadProperties.getPropertyValue("tomail");
//				MailUtil.sendEmail(tomail, "testreport", out.toString());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			}
//	  
	
	FreemarkerTemplateEngine ft=new FreemarkerTemplateEngine();

	public WebTestListener() {
		super();
	}
	
	private String writeResultToMailTemplate()
	{
		ITestNGMethod method[]=this.getAllTestMethods();
		List failedList=this.getFailedTests();
		List passedList=this.getPassedTests();
		
		
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();
		for(int j=0;j<failedList.size();j++)
		{
			ITestResult tr=(ITestResult) failedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}

				}
			}
			failedList1.add(tr);
		}
		for(int j=0;j<passedList.size();j++)
		{
			ITestResult tr=(ITestResult) passedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}

				}
			}
			passedList1.add(tr);
		}
		Map context=new HashMap();
    	context.put("date", new Date());
        context.put("failedList",failedList1);   
        context.put("passedList",passedList1); 
        context.put("casesize",passedList.size()+failedList.size()); 
        context.put("failcasesize",failedList.size());
        try {
			String content=ft.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
//	@Override
//	public void onFinish(ITestContext testContext) {
//		
//		super.onFinish(testContext);
//		//���ص���
//	
//		try {
//			if(ReadProperties.getPropertyValue("enable_email").equals("true"))
//			{
//				String emailContent=this.writeResultToMailTemplate();
//				String emailTitle=ReadProperties.getPropertyValue("mail_title")+"----"+this.getTime();
//				String toMail=ReadProperties.getPropertyValue("to_mail");
//				try {
//					if(this.getFailedTests()!=null&&this.getFailedTests().size()>0)
//					{
//						MailUtil.sendEmail(toMail,emailTitle, emailContent);
//						Log.info("email send to "+toMail+" success");
//					}else
//					{
//						MailUtil.sendEmail(ReadProperties.getPropertyValue("success_to_mail"),emailTitle, emailContent);
//						Log.info("email send to "+("success_to_mail")+" success");
//					}
//				} catch (Exception e) {
//					Log.fatal("email send fail :"+e.getMessage());
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//	}
//	
//
//
//    public String getTime()
//    {
//    	java.util.Calendar c=java.util.Calendar.getInstance();    
//        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
//       	return  f.format(c.getTime());    
//    }
}
