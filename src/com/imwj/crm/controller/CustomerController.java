package com.imwj.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imwj.common.utils.Page;
import com.imwj.crm.pojo.BaseDict;
import com.imwj.crm.pojo.Customer;
import com.imwj.crm.pojo.QueryVo;
import com.imwj.crm.service.BaseDictService;
import com.imwj.crm.service.CustomerService;

/**
 * 客户管理
 * @author SpongBob
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	//注解在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	//入口
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model){
		//fromType、custSource、custIndustry
	 	List<BaseDict> fromType = baseDictService.findCodeByItemName(fromTypeCode);
		List<BaseDict> industryType = baseDictService.findCodeByItemName(industryTypeCode);
		List<BaseDict> levelType = baseDictService.findCodeByItemName(levelTypeCode);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件查询分页对象:custName、custSource、custIndustry、custLevel
		Page<Customer> page = customerService.findPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//根据id查询用户
	@RequestMapping(value = "/customer/edit")
	public @ResponseBody Customer toEdit(Integer id){
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	
	//根据id删除用户
	@RequestMapping(value = "/customer/delete")
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
	//更新customer
	@RequestMapping(value = "/customer/update")
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomerByCustomer(customer);
		return "OK";
	}
	
}
