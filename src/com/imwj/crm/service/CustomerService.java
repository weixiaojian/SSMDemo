package com.imwj.crm.service;

import com.imwj.common.utils.Page;
import com.imwj.crm.pojo.Customer;
import com.imwj.crm.pojo.QueryVo;

public interface CustomerService {

	Page<Customer> findPageByQueryVo(QueryVo vo);

	void deleteCustomerById(Integer id);

	Customer findCustomerById(Integer id);

	void updateCustomerByCustomer(Customer customer);
}
