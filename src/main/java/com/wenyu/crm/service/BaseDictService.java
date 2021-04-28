package com.wenyu.crm.service;


import com.wenyu.crm.bean.BaseDict;

import java.util.List;

/**
 * Author:wenyu
 * 2021/4/27
 */

public interface BaseDictService {

    List<BaseDict> getBaseDictByCode(String code);
}
