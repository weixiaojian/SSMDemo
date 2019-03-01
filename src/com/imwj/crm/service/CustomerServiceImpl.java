package com.imwj.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imwj.common.utils.Page;
import com.imwj.crm.mapper.CustomerMapper;
import com.imwj.crm.pojo.Customer;
import com.imwj.crm.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	
	//填充page分页对象
	public Page<Customer> findPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//每页数
		vo.setSize(5);
		page.setSize(5);
		//判断当前页
		if(null != vo.getPage()){
			page.setPage(vo.getPage());
			vo.setStartRow((vo.getPage()-1)*vo.getSize());
		}
		if(null != vo.getCustIndustry() && !"".equals(vo.getCustName().trim())){
			vo.setCustName(vo.getCustName().trim());
		}
		if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
			vo.setCustSource(vo.getCustSource().trim());
		}
		if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
			vo.setCustIndustry(vo.getCustIndustry().trim());
		}
		if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
			vo.setCustLevel(vo.getCustLevel().trim());
		}
		//总条数
		page.setTotal(customerMapper.findCountByQueryVo(vo));
		//每页显示数据
		page.setRows(customerMapper.findCustomerListByQueryVo(vo));
		
		return page;
	}


	//根据id删除customer
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}


	//根据id查询用户
	public Customer findCustomerById(Integer id) {
		return customerMapper.findCustomerById(id);
	}


	//更新客户
	public void updateCustomerByCustomer(Customer customer) {
		customerMapper.updateCustomerByCustomer(customer);
	}
}
