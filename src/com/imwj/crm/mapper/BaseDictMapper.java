package com.imwj.crm.mapper;

import java.util.List;

import com.imwj.crm.pojo.BaseDict;

public interface BaseDictMapper {
	
	//根据dict_type_code查询dict_item_name
	public List<BaseDict> findCodeByItemName(String code);
	
}
