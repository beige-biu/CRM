package com.wenyu.crm.service.impl;

import com.wenyu.crm.bean.BaseDict;
import com.wenyu.crm.mapper.BaseDictMapper;
import com.wenyu.crm.service.BaseDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenyu
 * 2021/4/27
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Resource
    private BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> getBaseDictByCode(String code) {
        return baseDictMapper.getBaseDictByCode(code);
    }
}
