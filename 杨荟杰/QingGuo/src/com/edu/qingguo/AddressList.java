package com.edu.qingguo;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

/**
 * 
 * @author ÑîÜö½Ü
 *
 */

//¶©µ¥ÁÐ±í

public class AddressList {
	String address_url="/fgadmin/address/list";
	@Test
	public void testGetAddress() throws Exception{
//		CookieStore cookie=Common.getCookie("20000000000", "netease123");
		String result=HttpDriver.doGet(address_url);
		System.out.println(result);
//		Checker checker =new Checker(result);
//		checker.verifyXpath("message","success");
		
		
	}

}
