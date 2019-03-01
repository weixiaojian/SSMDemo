package com.imwj.crm.service;

import java.util.List;

import com.imwj.crm.pojo.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> findCodeByItemName(String dict_item_name);
}
