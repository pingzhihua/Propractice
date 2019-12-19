package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;
/**
 * 
 * @author 冀珊珊
 *
 */
public class AllTest {
	String login_url = "/common/fgadmin/login";
	String list_url = "/common/skuList";
	String getfee_url = "/common/getTransportFee";
	String delete_address_list = "/fgadmin/address/delete";
	String new_address_list = "/common/fgadmin/address/new";
	String address_url = "/fgadmin/address/list";
	String submit_url = "/fgadmin/orders/submit";
	Checker check = null;

	public void login(Object phoneArea, Object phoneNumber, Object password) {
		JSONObject user = new JSONObject();
		user.element("phoneArea", phoneArea);
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		check = new Checker(result);
	}

	@Test
	public void testLoginSuccess() throws Exception {
		login("86", "20000000000", "netease123");
		check.verifyXpath("message", "success");
	}

	@Test
	public void testLoginForWrongPhone() throws Exception {
		login(86, "20000000000", "netease123");
		check.verifyXpath("message", "fail");
	}

	@Test
	public void testLoginForWrongNumber() throws Exception {
		login("86", "2000000888", "netease123");
		check.verifyXpath("message", "fail");
	}

	public void skuit(String para) throws Exception {
		String result = HttpDriver.doGet(list_url + para);
		System.out.println(result);
		check = new Checker(result);
	}

	@Test(description = "获取所有商品列表成功")
	public void test1() throws Exception {
		skuit("");
	}

	@Test
	public void testDeleteSuccess() throws Exception {
		JSONObject para = new JSONObject();
		para.element("login", "true");
		para.element("id", "77243286");
		String result = HttpDriver.doPost(delete_address_list, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "success");
	}

	@Test
	public void testDeleteFail() throws Exception {
		JSONObject para = new JSONObject();
		para.element("login", "fail");
		para.element("id", "77243286");
		String result = HttpDriver.doPost(delete_address_list, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "请先登录！");
	}

	@Test
	public void testGetFee() throws Exception {
		String result = HttpDriver.doGet(getfee_url);
		System.out.println(result);
	}

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
		String result = HttpDriver.doPost(new_address_list, para);
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
		String result = HttpDriver.doPost(new_address_list, para);
		System.out.println(result);
		Checker checker = new Checker(result);
		checker.assertXpath("message", "请先登录！");
	}

	@Test
	public void testGetAddress() throws Exception {
		String result = HttpDriver.doGet(address_url);
		System.out.println(result);
	}

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
