package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

/**
 * 
 * @author ������
 *
 */

//��ȡ�˷�

public class GetTransportFee {
	String getfee_url = "/common/getTransportFee";

	@Test
	public void testGetAddress() throws Exception {
		String result = HttpDriver.doGet(getfee_url);
		System.out.println(result);
		// Checker checker =new Checker(result);
		// checker.verifyXpath("message","success");

	}

}
