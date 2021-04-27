package com.wenyu.crm.controller;

import com.wenyu.crm.bean.QueryVo;
import com.wenyu.crm.service.BaseDictService;
import com.wenyu.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Author:wenyu
 * 2021/4/27
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private BaseDictService baseDictService;

    @Resource
    private CustomerService customerService;

    @Value("${customer_from_type}")
    private String customer_from_type;

    @Value("${customer_industry_type}")
    private String customer_industry_type;

    @Value("${customer_level_type}")
    private String customer_level_type;

    public CustomerController() {
    }


    @RequestMapping("index")
    private String index(Model model ,QueryVo queryVo){



        return "index";
    }
}
