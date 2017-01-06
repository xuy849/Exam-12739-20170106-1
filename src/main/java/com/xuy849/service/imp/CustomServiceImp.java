package com.xuy849.service.imp;

import org.springframework.stereotype.Service;

import com.xuy849.mapper.CustomMapper;
import com.xuy849.service.CustomService;
import com.xuy849.util.Util;

@Service
public class CustomServiceImp implements CustomService{

	@Override
	public boolean isCustomExist(String first_Name) throws Exception {
		// TODO Auto-generated method stub
		CustomMapper customMapper = Util.getCustomMapper();
		
		int count = customMapper.findCustomByFirstName(first_Name);
		
		return (count>=1)?true:false;
	}

}
