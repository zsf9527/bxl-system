package com.zsf.admin.service;

import java.util.List;

import com.zsf.admin.entity.SysDict;
import com.zsf.core.service.CurdService;

/**
 * 字典管理
 * @author zsf
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
