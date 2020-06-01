package com.zsf.admin.service;

import java.util.List;

import com.zsf.admin.entity.SysConfig;
import com.zsf.core.service.CurdService;

/**
 * 系统配置管理
 * @author zsf
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
