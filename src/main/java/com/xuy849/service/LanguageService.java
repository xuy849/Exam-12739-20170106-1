package com.xuy849.service;

import java.util.List;

import com.xuy849.pojo.Language;

public interface LanguageService {
	
	//查询出所有的语言列表
	public List<Language> queryLanguage() throws Exception;
	
}
