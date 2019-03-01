package com.imwj.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imwj.crm.pojo.Customer;
import com.imwj.crm.pojo.QueryVo;

public interface CustomerMapper {
	
	//查询总条数
	public Integer findCountByQueryVo(QueryVo vo);
	//查询分页数据
	public List<Customer> findCustomerListByQueryVo(QueryVo vo);
	//根据id查询数据
	public Customer findCustomerById(Integer id);
	//根据id删除数据
	public void deleteCustomerById(Integer id);
	//修改customer
	public void updateCustomerByCustomer(Customer customer);
}
