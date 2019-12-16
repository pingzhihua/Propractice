package com.webtest.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
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

import com.webtest.utils.ReadProperties;

import freemarker.template.Configuration;
import freemarker.template.Template;

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
	public void onFinish(ITestContext testContext) {
		//��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = dateFormat.format(date);
		//���в�����������
		ITestNGMethod[] allTest = testContext.getAllTestMethods();
		int count = allTest.length;
		//ʧ�ܲ�����������
		Set<ITestResult> tResultsFail = testContext.getFailedTests().getAllResults();
		int failCount = tResultsFail.size();
		//�ɹ���������
		Set<ITestResult> trSuccess = testContext.getPassedTests().getAllResults();
		
		String out = Freemarker.getFreemarker(now, count, failCount, trSuccess);
		
		String tomail;
		try {
			tomail = ReadProperties.getPropertyValue("tomail");
			MailUtil.sendEmail(tomail, "�Զ������Ա���", out.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
