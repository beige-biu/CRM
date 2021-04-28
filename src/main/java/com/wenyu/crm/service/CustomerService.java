package com.wenyu.crm.service;


import com.wenyu.crm.bean.Customer;
import com.wenyu.crm.bean.QueryVo;
import com.wenyu.crm.util.Page;

/**
 * Author:wenyu
 * 2021/4/27
 */

public interface CustomerService {
    /**
     * 查询查询条件，分页查询用户列表
     * @param vo
     * @return
     */
    Page<Customer> getCustomerByQueryVo(QueryVo vo);


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
