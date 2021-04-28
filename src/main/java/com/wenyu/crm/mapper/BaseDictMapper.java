package com.wenyu.crm.mapper;

import com.wenyu.crm.bean.BaseDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



/**
 * 字典数据表持久化接口
 * @author wenyu
 *
 */
@Mapper
public interface BaseDictMapper {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
