package com.xuy849.service.imp;

import org.junit.Before;
import org.junit.Test;

import com.xuy849.service.CustomService;
import com.xuy849.util.Util;

public class CustomServiceImpTest {

	@Before
	public void setUp(){
		
	}
	
	
	@Test
	public void isCustomExistTest(){
		CustomService customService = Util.getCustomService();
		
		try {
			boolean b = customService.isCustomExist("MARY");
			
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
