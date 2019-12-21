package com.example.demo;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/**
 * 
 * @author 杨荟杰
 *
 */

//登录

@RestController
public class Login {
	public static Cookie cookie;

	@ResponseBody
	@RequestMapping(value="/common/fgadmin/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JSONObject getByJSON(@RequestBody JSONObject jsonParam,HttpServletResponse response){
//		直接将json信息打印出来
//		System.out.println(jsonParam.toString());
		String phoneArea=jsonParam.getString("phoneArea");
		String phoneNumber=jsonParam.getString("phoneNumber");
		String password=jsonParam.getString("password");
		
		JSONObject result=new JSONObject();
		
		if(phoneArea.equals("86") && phoneNumber.equals("20000000000") && password.equals("netease123")){
			cookie = new Cookie("login","true");
			response.addCookie(cookie);
			result.element("message","success");
		}
		else{
			result.element("message","fail");
		}
		return result;
	}

}
