package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

public class SkulistTest {
	String list_url = "/common/skuList";
	Checker check = null;

	public void skuit(String para) throws Exception {
		String result = HttpDriver.doGet(list_url + para);
		System.out.println(result);
		check = new Checker(result);
	}

	@Test(description = "获取所有商品列表成功")
	public void test1() throws Exception {
		skuit("");
	}
}
