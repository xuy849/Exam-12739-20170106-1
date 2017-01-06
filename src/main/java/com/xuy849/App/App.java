package com.xuy849.App;

import java.util.List;

import com.xuy849.pojo.Language;
import com.xuy849.service.CustomService;
import com.xuy849.util.Util;

public class App {
	public static void main(String args[]){
		//isCustomExistTest测试
		/*isCustomExistTest();*/
		
		//查询出所有的商品列表
		queryLanguageTest();
	}
	
	private static void isCustomExistTest(){
		CustomService customService = Util.getCustomService();
		
		try {
			boolean b = customService.isCustomExist("MARYY");
			
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//查询出所有的商品列表
	public static void queryLanguageTest(){
		try {
			List<Language> list = Util.getLanguageService().queryLanguage();
			
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
