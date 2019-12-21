package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author 杨荟杰
 *
 */

//spring boot 简单运行 hello world
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String show(){
		return "hello world";
	}

}
