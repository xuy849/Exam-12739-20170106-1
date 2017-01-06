package com.xuy849.mapper;

import java.util.List;

import com.xuy849.pojo.Language;

public interface LanguageMapper {

	//查询所有的语言列表
	public List<Language> selectLanguage() throws Exception;
}
