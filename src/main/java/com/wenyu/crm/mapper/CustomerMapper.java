package com.wenyu.crm.mapper;

import com.wenyu.crm.bean.Customer;
import com.wenyu.crm.bean.QueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



/**
 * 客户信息持久化接口
 * @author wenyu
 *
 */
@Mapper
public interface CustomerMapper {

	/**
	 * 查询查询条件，分页查询用户列表
	 * @param vo
	 * @return
	 */
	List<Customer> getCustomerByQueryVo(QueryVo vo);
	
	/**
	 * 跟据查询条件查询总记录数
	 * @param vo
	 * @return
	 */
	Integer getCountByQueryVo(QueryVo vo);
	
	/**
	 * 跟据id查询用户信息
	 * @param id
	 * @return
	 */
	Customer getCustomerById(Integer id);
	
	/**
	 * 更新用户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	void deleteCustomer(Integer id);
}
