package com.nci.syncengine.wsbg.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZFJDao;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;
import com.nci.syncengine.wsbg.service.SWGL_TZFJService;
@Service
public class SWGL_TZFJServiceImpl extends BaseServiceImpl<SWGL_TZFJ, String> implements
		SWGL_TZFJService {

	@Autowired
	protected void setSWGL_TZFJDao(SWGL_TZFJDao SWGL_TZFJDao) {
		setBaseDao(SWGL_TZFJDao);
	}

	protected SWGL_TZFJDao getSWGL_TZFJDao() {
		return (SWGL_TZFJDao) this.baseDao;
	}

	@Override
	public SWGL_TZFJ getBySWGL_TZFJId(String SWGL_TZTGId) {
		return getSWGL_TZFJDao().findBySWGL_TZFJId(SWGL_TZTGId);
		
	}

}
