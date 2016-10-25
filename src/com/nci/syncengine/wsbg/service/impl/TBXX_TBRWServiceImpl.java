package com.nci.syncengine.wsbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZTGDao;
import com.nci.syncengine.wsbg.dao.TBXX_TBRWDao;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
import com.nci.syncengine.wsbg.service.TBXX_TBRWService;
@Service
public class TBXX_TBRWServiceImpl extends BaseServiceImpl<TBXX_TBRW, Integer> implements
		TBXX_TBRWService {
	@Autowired
	protected void setTBXX_TBRWDao(TBXX_TBRWDao TBXX_TBRWDao) {
		setBaseDao(TBXX_TBRWDao);
	}

	protected TBXX_TBRWDao getTBXX_TBRWDao() {
		return (TBXX_TBRWDao) this.baseDao;
	}
}
