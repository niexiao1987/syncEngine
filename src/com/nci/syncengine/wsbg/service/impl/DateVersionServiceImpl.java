package com.nci.syncengine.wsbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.DBZHJC_DBSXDao;
import com.nci.syncengine.wsbg.dao.DateVersionDao;
import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.service.DateVersionService;
@Service
public class DateVersionServiceImpl extends BaseServiceImpl<DateVersion, String> implements
		DateVersionService {
	@Autowired
	protected void setDateVersionDao(DateVersionDao dateVersionDao) {
		setBaseDao(dateVersionDao);
	}

	protected DateVersionDao getDateVersionDao() {
		return (DateVersionDao) this.baseDao;
	}
}
