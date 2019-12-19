package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;
/**
 * 
 * @author jishanshan
 *
 */
public class NewAddressTest {
	String address_list = "/common/fgadmin/address/new";

	@Test
	public void testNewSuccess() throws Exception {
		JSONObject para = new JSONObject();
		para.element("login", "true");
		para.element("id", "");
		para.element("receiverName", "liming");
		para.element("cellPhone", "14567788678");
		para.element("addressDetail", "wandaguangchang");
		para.element("province", "zhejiangsheng");
		para.element("city", "hangzhoushi");
		para.element("area", "binjiangqu");
		String result = HttpDriver.doPost(address_list, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "success");
	}

	@Test
	public void testNewFail() throws Exception {
		JSONObject para = new JSONObject();
		para.element("login", "fail");
		para.element("id", "");
		para.element("receiverName", "liming");
		para.element("cellPhone", "14567788678");
		para.element("addressDetail", "wandaguangchang");
		para.element("province", "zhejiangsheng");
		para.element("city", "hangzhoushi");
		para.element("area", "binjiangqu");
		String result = HttpDriver.doPost(address_list, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "请先登录！");
	}

}
