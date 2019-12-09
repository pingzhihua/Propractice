package com.webtest.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;


public class MailUtil {
	
	static int port = 25;
    static String server = "smtp.126.com";

    static String from = "xiaochangchang21@126.com";

//    static String user = "xiaochangchang21@126.com";
    static String password = "210214wxc";   //授权码


    public static void sendEmail(String email, String subject, String body) throws IOException {
        try {
        	//创建邮件配置
        	String sendmail=ReadProperties.getPropertyValue("sendmail");
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", true);//请求认证
            Transport transport = null;
            //获取session对象
            Session session = Session.getDefaultInstance(props,null);
            transport = session.getTransport("smtp");
            transport.connect(server, sendmail, password);
            
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            
            InternetAddress fromAddress = new InternetAddress(sendmail,from,"UTF-8");
            msg.setFrom(fromAddress);
            String emailList[]=email.split(",");
            InternetAddress[] toAddress = new InternetAddress[emailList.length];
            
            for(int i=0;i<emailList.length;i++)
            {
            	toAddress[i]=new InternetAddress(emailList[i]);
            }
          //msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.addRecipients(Message.RecipientType.TO, toAddress); //头部字段
            msg.setSubject(subject, "UTF-8");   
            msg.setContent(body, "text/html;charset=utf-8");
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    @Test
    public static void main(String args[]) throws IOException
    {
//    MailUtil.sendEmail("xiaochangchang21@126.com", "testreport", "11");
    	
    	MailUtil.sendEmail("xiaochangchang21@126.com", "星期二", "测试");
		if(System.getProperty("os.name").contains("w"))
		{
			System.out.println(System.getProperty("os.name"));
			System.out.println("ok");
		} 
    }

}
