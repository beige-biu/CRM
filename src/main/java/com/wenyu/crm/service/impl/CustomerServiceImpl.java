package com.wenyu.crm.service.impl;/*
 *Author:wenyu
 *2021/4/27
 */

import com.wenyu.crm.bean.Customer;
import com.wenyu.crm.bean.QueryVo;
import com.wenyu.crm.mapper.CustomerMapper;
import com.wenyu.crm.service.CustomerService;
import com.wenyu.crm.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> getCustomerByQueryVo(QueryVo vo) {
        //计算分页查询从哪条记录开始
        vo.setStart((vo.getPage() - 1) * vo.getRows());

        //查询总记录数
        Integer total = customerMapper.getCountByQueryVo(vo);

        //查询每页的数据列表
        List<Customer> list = customerMapper.getCustomerByQueryVo(vo);

        Page<Customer> page = new Page<Customer>(total,vo.getPage(),vo.getRows(),list);
        return page;

    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }
}
