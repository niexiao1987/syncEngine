package com.nci.syncengine.wsbg.dao;

import java.util.List;

import com.nci.syncengine.base.dao.BaseDao;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;

public interface SFSQ_YHZHDao extends BaseDao<SFSQ_YHZH, String> {

	public List<SFSQ_YHZH> findAll();

	public SFSQ_YHZH addSFSQ_YHZH(SFSQ_YHZH entity);

	public String newYHBH();

}
