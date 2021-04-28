package com.wenyu.crm.controller;

import com.wenyu.crm.bean.BaseDict;
import com.wenyu.crm.bean.Customer;
import com.wenyu.crm.bean.QueryVo;
import com.wenyu.crm.service.BaseDictService;
import com.wenyu.crm.service.CustomerService;
import com.wenyu.crm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenyu
 * 2021/4/27
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

   /* @Value("${customer_from_type}")
    private String customer_from_type;

    @Value("${customer_industry_type}")
    private String customer_industry_type;

    @Value("${customer_level_type}")
    private String customer_level_type;*/




    @RequestMapping("list")
    private String index(Model model ,QueryVo queryVo){

        //查询来源   可以通过配置文件来代替
        List<BaseDict> fromType = baseDictService.getBaseDictByCode("002");
        //查询行业
        List<BaseDict> industryType = baseDictService.getBaseDictByCode("001");
        //查询客户级别
        List<BaseDict> levelType = baseDictService.getBaseDictByCode("006");

        /*List<BaseDict> fromType = baseDictService.getBaseDictByCode(customer_from_type);
        //查询行业
        List<BaseDict> industryType = baseDictService.getBaseDictByCode(customer_industry_type);
        //查询客户级别
        List<BaseDict> levelType = baseDictService.getBaseDictByCode(customer_level_type);*/

        //设置返回值
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);


        //根据查询条件分页查询用户列表
        Page<Customer> page = customerService.getCustomerByQueryVo(queryVo);
        //设置分页数返回
        model.addAttribute("page", page);
        //返回查询条件
        model.addAttribute("vo", queryVo);
        return "customer";
    }


    @RequestMapping("edit")
    @ResponseBody
    private Customer edit(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Customer customer){
        String msg = "1";
        try {
            customerService.updateCustomer(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id){
        String msg = "1";
        try {
            customerService.deleteCustomer(id);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }


}
