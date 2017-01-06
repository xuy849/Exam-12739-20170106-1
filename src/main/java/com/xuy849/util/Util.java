package com.xuy849.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xuy849.mapper.CustomMapper;
import com.xuy849.mapper.FilmMapper;
import com.xuy849.mapper.LanguageMapper;
import com.xuy849.service.CustomService;
import com.xuy849.service.FilmService;
import com.xuy849.service.LanguageService;

public class Util {
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static ClassPathXmlApplicationContext getApplicationContext(){
		if(applicationContext==null)
			applicationContext = new ClassPathXmlApplicationContext(Constant.BEANS_PATH);
		return applicationContext;
	}
	
	public static CustomMapper getCustomMapper(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		
		return (CustomMapper) applicationContext.getBean("customMapper");
	}
	
	public static CustomService getCustomService(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		
		return (CustomService) applicationContext.getBean("customServiceImp");
	}
	
	public static LanguageMapper getLanguageMapper(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		
		return (LanguageMapper) applicationContext.getBean("languageMapper");
	}
	
	public static LanguageService getLanguageService(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		return (LanguageService) applicationContext.getBean("languageServiceImp");
	}
	
	public static FilmMapper getFilmMapper(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		
		return (FilmMapper) applicationContext.getBean("filmMapper");
	}
	
	public static FilmService getFilmService(){
		if(applicationContext==null)
			applicationContext = Util.getApplicationContext();
		
		return (FilmService)applicationContext.getBean("filmServiceImp");
	}
}
