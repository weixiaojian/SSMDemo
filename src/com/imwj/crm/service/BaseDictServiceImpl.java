package com.imwj.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imwj.crm.mapper.BaseDictMapper;
import com.imwj.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService{
											
	@Autowired
	private BaseDictMapper baseDictmapper;
	
	//查询条件的下拉列表
	public List<BaseDict> findCodeByItemName(String dict_item_name){
		List<BaseDict> list = baseDictmapper.findCodeByItemName(dict_item_name);
		return list;  
	}
}
