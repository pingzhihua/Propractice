package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;
/**
 * 
 * @author yanghuijie
 *
 */
public class SubmitTest {

	String submit_url = "/fgadmin/orders/submit";

	@Test
	public void testSubmit() throws Exception {
		JSONObject para = new JSONObject();
		para.element("login", "true");
		para.element("receiverName", "liming");
		para.element("cellPhone", "14567788678");
		para.element("province", "zhejiangsheng");
		para.element("city", "hangzhoushi");
		para.element("area", "binjiangqu");
		para.element("transportFee", "6");
		String result = HttpDriver.doPost(submit_url, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "success");
	}

}
