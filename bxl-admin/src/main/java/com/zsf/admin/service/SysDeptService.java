package com.zsf.admin.service;

import java.util.List;

import com.zsf.admin.entity.SysDept;
import com.zsf.core.service.CurdService;

/**
 * 机构管理
 * @author zsf
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param
	 * @return
	 */
	List<SysDept> findTree();
}
