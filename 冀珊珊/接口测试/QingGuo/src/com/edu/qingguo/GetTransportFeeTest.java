package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
/**
 * 
 * @author yanghuijie
 *
 */
public class GetTransportFeeTest {
	String getfee_url = "/common/getTransportFee";

	@Test
	public void testGetAddress() throws Exception {
		String result = HttpDriver.doGet(getfee_url);
		System.out.println(result);
	}

}
