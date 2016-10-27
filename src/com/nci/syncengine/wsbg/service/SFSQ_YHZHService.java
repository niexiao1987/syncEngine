package com.nci.syncengine.wsbg.service;

import java.util.List;

import com.nci.syncengine.base.service.BaseService;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;

public interface SFSQ_YHZHService extends BaseService<SFSQ_YHZH, String> {

	public List<SFSQ_YHZH> findAll();

	public boolean addSFSQ_YHZH(SFSQ_YHZH entity);

	public String newYHBH();
	
	public boolean isExitByYHZH(String YHZH);
	
	public void delByYHZH(String YHZH);
	
	public SFSQ_YHZH getByYHBH(String YHBH);
}
