package com.xuy849.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xuy849.pojo.Language;
import com.xuy849.service.LanguageService;
import com.xuy849.util.Util;

@Service
public class LanguageServiceImp implements LanguageService{

	
	//查询出所有的语言列表
	@Override
	public List<Language> queryLanguage() throws Exception {
		// TODO Auto-generated method stub
		List<Language>  list = Util.getLanguageMapper().selectLanguage();
		
		return list;
	}

}
