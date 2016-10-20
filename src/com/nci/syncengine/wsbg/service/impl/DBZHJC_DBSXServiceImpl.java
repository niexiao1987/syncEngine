package com.nci.syncengine.wsbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.DBZHJC_DBSXDao;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.syncengine.wsbg.service.DBZHJC_DBSXService;

@Service
public class DBZHJC_DBSXServiceImpl extends BaseServiceImpl<DBZHJC_DBSX, String> implements DBZHJC_DBSXService{
	@Autowired
	protected void setDBZHJC_DBSXDao(DBZHJC_DBSXDao DBZHJC_DBSXDao) {
		setBaseDao(DBZHJC_DBSXDao);
	}

	protected DBZHJC_DBSXDao getDBZHJC_DBSXDao() {
		return (DBZHJC_DBSXDao) this.baseDao;
	}
}
