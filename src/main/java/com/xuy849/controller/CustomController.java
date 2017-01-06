package com.xuy849.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuy849.util.Util;

@RestController
@RequestMapping(path="/custom")
public class CustomController {
	
	
	//登陆认证
	//如果用户不存在，则返回No
	//如果用户存在，则返回YES
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public String queryCustom(
			@RequestParam(name="firstName",required=true) String firstName){
		
		boolean b = false;
		
		try {
			b = Util.getCustomService().isCustomExist(firstName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(b)
			return "YES";
		return "NO";
	}
}
